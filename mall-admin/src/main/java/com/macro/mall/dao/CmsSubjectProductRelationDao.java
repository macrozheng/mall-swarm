package com.macro.mall.dao;

import com.macro.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Customize product and thematic relationship operations Dao
 * Created by macro on 2018/4/26.
 */
public interface CmsSubjectProductRelationDao {
    /**
     * Batch creation
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
