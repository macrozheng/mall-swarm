package com.macro.mall.portal.service.impl;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.model.PmsProductFullReduction;
import com.macro.mall.model.PmsProductLadder;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.portal.dao.PortalProductDao;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.PromotionProduct;
import com.macro.mall.portal.service.OmsPromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by macro on 2018/8/27.
 * Promotion managementService implementation class
 */
@Service
public class OmsPromotionServiceImpl implements OmsPromotionService {
    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList) {
        //1.First, CartItem was grouped according to productId, and the discount was calculated based on spu
        Map<Long, List<OmsCartItem>> productCartMap = groupCartItemBySpu(cartItemList);
        //2.Get information on offers for all products
        List<PromotionProduct> promotionProductList = getPromotionProductList(cartItemList);
        //3.Calculate the promotional price of the product according to the product promotion type
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        for (Map.Entry<Long, List<OmsCartItem>> entry : productCartMap.entrySet()) {
            Long productId = entry.getKey();
            PromotionProduct promotionProduct = getPromotionProductById(productId, promotionProductList);
            List<OmsCartItem> itemList = entry.getValue();
            Integer promotionType = promotionProduct.getPromotionType();
            if (promotionType == 1) {
                //Single product promotion
                for (OmsCartItem item : itemList) {
                    CartPromotionItem cartPromotionItem = new CartPromotionItem();
                    BeanUtils.copyProperties(item,cartPromotionItem);
                    cartPromotionItem.setPromotionMessage("Single product promotion");
                    //Product original price-promotional price
                    PmsSkuStock skuStock = getOriginalPrice(promotionProduct, item.getProductSkuId());
                    BigDecimal originalPrice = skuStock.getPrice();
                    cartPromotionItem.setReduceAmount(originalPrice.subtract(skuStock.getPromotionPrice()));
                    cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
                    cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
                    cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
                    cartPromotionItemList.add(cartPromotionItem);
                }
            } else if (promotionType == 3) {
                //Discount
                int count = getCartItemCount(itemList);
                PmsProductLadder ladder = getProductLadder(count, promotionProduct.getProductLadderList());
                if(ladder!=null){
                    for (OmsCartItem item : itemList) {
                        CartPromotionItem cartPromotionItem = new CartPromotionItem();
                        BeanUtils.copyProperties(item,cartPromotionItem);
                        String message = getLadderPromotionMessage(ladder);
                        cartPromotionItem.setPromotionMessage(message);
                        //Product original price-discount * product original price
                        PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
                        BigDecimal originalPrice = skuStock.getPrice();
                        BigDecimal reduceAmount = originalPrice.subtract(ladder.getDiscount().multiply(originalPrice));
                        cartPromotionItem.setReduceAmount(reduceAmount);
                        cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
                        cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
                        cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
                        cartPromotionItemList.add(cartPromotionItem);
                    }
                }else{
                    handleNoReduce(cartPromotionItemList,itemList,promotionProduct);
                }
            } else if (promotionType == 4) {
                //Full reduction
                BigDecimal totalAmount= getCartItemAmount(itemList,promotionProductList);
                PmsProductFullReduction fullReduction = getProductFullReduction(totalAmount,promotionProduct.getProductFullReductionList());
                if(fullReduction!=null){
                    for (OmsCartItem item : itemList) {
                        CartPromotionItem cartPromotionItem = new CartPromotionItem();
                        BeanUtils.copyProperties(item,cartPromotionItem);
                        String message = getFullReductionPromotionMessage(fullReduction);
                        cartPromotionItem.setPromotionMessage(message);
                        //(Original Price / Total Price) * Full minus Amount
                        PmsSkuStock skuStock= getOriginalPrice(promotionProduct, item.getProductSkuId());
                        BigDecimal originalPrice = skuStock.getPrice();
                        BigDecimal reduceAmount = originalPrice.divide(totalAmount,RoundingMode.HALF_EVEN).multiply(fullReduction.getReducePrice());
                        cartPromotionItem.setReduceAmount(reduceAmount);
                        cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
                        cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
                        cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
                        cartPromotionItemList.add(cartPromotionItem);
                    }
                }else{
                    handleNoReduce(cartPromotionItemList,itemList,promotionProduct);
                }
            } else {
                //No discount
                handleNoReduce(cartPromotionItemList, itemList,promotionProduct);
            }
        }
        return cartPromotionItemList;
    }

    /**
     * Get information on offers for all products
     */
    private List<PromotionProduct> getPromotionProductList(List<OmsCartItem> cartItemList) {
        List<Long> productIdList = new ArrayList<>();
        for(OmsCartItem cartItem:cartItemList){
            productIdList.add(cartItem.getProductId());
        }
        return portalProductDao.getPromotionProductList(productIdList);
    }

    /**
     * Use the spu as the unit to perform minutes groups on the shopping cart products
     */
    private Map<Long, List<OmsCartItem>> groupCartItemBySpu(List<OmsCartItem> cartItemList) {
        Map<Long, List<OmsCartItem>> productCartMap = new TreeMap<>();
        for (OmsCartItem cartItem : cartItemList) {
            List<OmsCartItem> productCartItemList = productCartMap.get(cartItem.getProductId());
            if (productCartItemList == null) {
                productCartItemList = new ArrayList<>();
                productCartItemList.add(cartItem);
                productCartMap.put(cartItem.getProductId(), productCartItemList);
            } else {
                productCartItemList.add(cartItem);
            }
        }
        return productCartMap;
    }

    /**
     * Get full reduction promotion information
     */
    private String getFullReductionPromotionMessage(PmsProductFullReduction fullReduction) {
        StringBuilder sb = new StringBuilder();
        sb.append("Full discount：");
        sb.append("satisfied");
        sb.append(fullReduction.getFullPrice());
        sb.append("dollar，");
        sb.append("minus");
        sb.append(fullReduction.getReducePrice());
        sb.append("dollar");
        return sb.toString();
    }

    /**
     * Processing of products that do not meet the preferential conditions
     */
    private void handleNoReduce(List<CartPromotionItem> cartPromotionItemList, List<OmsCartItem> itemList,PromotionProduct promotionProduct) {
        for (OmsCartItem item : itemList) {
            CartPromotionItem cartPromotionItem = new CartPromotionItem();
            BeanUtils.copyProperties(item,cartPromotionItem);
            cartPromotionItem.setPromotionMessage("无优惠");
            cartPromotionItem.setReduceAmount(new BigDecimal(0));
            PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
            if(skuStock!=null){
                cartPromotionItem.setRealStock(skuStock.getStock()-skuStock.getLockStock());
            }
            cartPromotionItem.setIntegration(promotionProduct.getGiftPoint());
            cartPromotionItem.setGrowth(promotionProduct.getGiftGrowth());
            cartPromotionItemList.add(cartPromotionItem);
        }
    }

    private PmsProductFullReduction getProductFullReduction(BigDecimal totalAmount,List<PmsProductFullReduction> fullReductionList) {
        //Sort by high to low Sort
        fullReductionList.sort(new Comparator<PmsProductFullReduction>() {
            @Override
            public int compare(PmsProductFullReduction o1, PmsProductFullReduction o2) {
                return o2.getFullPrice().subtract(o1.getFullPrice()).intValue();
            }
        });
        for(PmsProductFullReduction fullReduction:fullReductionList){
            if(totalAmount.subtract(fullReduction.getFullPrice()).intValue()>=0){
                return fullReduction;
            }
        }
        return null;
    }

    /**
     * Get discounted promotions
     */
    private String getLadderPromotionMessage(PmsProductLadder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append("打折优惠：");
        sb.append("满");
        sb.append(ladder.getCount());
        sb.append("件，");
        sb.append("打");
        sb.append(ladder.getDiscount().multiply(new BigDecimal(10)));
        sb.append("折");
        return sb.toString();
    }

    /**
     * According to the purchase quantity strategy meet the conditions for discounts
     */
    private PmsProductLadder getProductLadder(int count, List<PmsProductLadder> productLadderList) {
        //Sort by Count from Big to Small
        productLadderList.sort(new Comparator<PmsProductLadder>() {
            @Override
            public int compare(PmsProductLadder o1, PmsProductLadder o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        for (PmsProductLadder productLadder : productLadderList) {
            if (count >= productLadder.getCount()) {
                return productLadder;
            }
        }
        return null;
    }

    /**
     * Get Count of Designated products in Shopping cart
     */
    private int getCartItemCount(List<OmsCartItem> itemList) {
        int count = 0;
        for (OmsCartItem item : itemList) {
            count += item.getQuantity();
        }
        return count;
    }

    /**
     * Get the total price of Designated products in your shopping cart
     */
    private BigDecimal getCartItemAmount(List<OmsCartItem> itemList, List<PromotionProduct> promotionProductList) {
        BigDecimal amount = new BigDecimal(0);
        for (OmsCartItem item : itemList) {
            //Calculate the original price of the product
            PromotionProduct promotionProduct = getPromotionProductById(item.getProductId(), promotionProductList);
            PmsSkuStock skuStock = getOriginalPrice(promotionProduct,item.getProductSkuId());
            amount = amount.add(skuStock.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return amount;
    }

    /**
     * Get the original price of the product
     */
    private PmsSkuStock getOriginalPrice(PromotionProduct promotionProduct, Long productSkuId) {
        for (PmsSkuStock skuStock : promotionProduct.getSkuStockList()) {
            if (productSkuId.equals(skuStock.getId())) {
                return skuStock;
            }
        }
        return null;
    }

    /**
     * Get the promotion information of the product according to the product id
     */
    private PromotionProduct getPromotionProductById(Long productId, List<PromotionProduct> promotionProductList) {
        for (PromotionProduct promotionProduct : promotionProductList) {
            if (productId.equals(promotionProduct.getId())) {
                return promotionProduct;
            }
        }
        return null;
    }
}
