package com.macro.mall.portal.service;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.portal.domain.HomeContentResult;

import java.util.List;

/**
 * Homepage content managementService
 * Created by macro on 2019/1/28.
 */
public interface HomeService {

    /**
     * Get Home Content
     */
    HomeContentResult content();

    /**
     * Home product recommendation
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * Get Product Categories
     * @param parentId 0: Get the first-level classification; Other: Get the specified second-level classification
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * Get topics based on topic classification
     * @param cateId special Subject Category id
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
