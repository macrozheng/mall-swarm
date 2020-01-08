package com.macro.mall.portal.dao;

import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.portal.domain.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Portal Order Custom Dao
 * Created by macro on 2018/9/4.
 */
public interface PortalOrderDao {
    /**
     * Get order and order product details
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * Modify the lock stock and real stock of the pms_sku_stock table
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
     * Get overtime orders
     * @param minute Timeout（minutes）
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * Get overtime order
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
     * Release the inventory lock of cancellation order
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);

}
