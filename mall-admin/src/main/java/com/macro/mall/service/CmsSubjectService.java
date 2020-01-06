package com.macro.mall.service;

import com.macro.mall.model.CmsSubject;

import java.util.List;

/**
 * Commodity topics Service
 * Created by macro on 2018/6/1.
 */
public interface CmsSubjectService {
    /**
     * Query all topics
     */
    List<CmsSubject> listAll();

    /**
     * Pagination query topic
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
}
