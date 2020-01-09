package com.macro.mall.search.dao;

import com.macro.mall.search.domain.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Search Product Management Custom Dao in Systematic
 * Created by macro on 2018/6/19.
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
