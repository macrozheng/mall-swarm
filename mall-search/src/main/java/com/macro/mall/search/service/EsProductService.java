package com.macro.mall.search.service;

import com.macro.mall.search.domain.EsProduct;
import com.macro.mall.search.domain.EsProductRelatedInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品搜索managementService
 * Created by macro on 2018/6/19.
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     * according toid删除商品
     */
    void delete(Long id);

    /**
     * according toidCreate product
     */
    EsProduct create(Long id);

    /**
     * Delete items in bulk
     */
    void delete(List<Long> ids);

    /**
     * according toKeywords搜索Name或者Subtitle
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * according toKeywords搜索Name或者Subtitle复合查询
     */
    Page<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize,Integer sort);

    /**
     * according to商品id推荐相关商品
     */
    Page<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize);

    /**
     * 获取搜索词相关品牌、minutes类、Attributes
     */
    EsProductRelatedInfo searchRelatedInfo(String keyword);
}
