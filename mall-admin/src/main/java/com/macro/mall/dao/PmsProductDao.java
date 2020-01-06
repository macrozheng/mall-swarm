package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * Product Custom Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductDao {
    /**
     * Get product editing information
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
