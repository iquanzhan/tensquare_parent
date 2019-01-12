package com.chengxiaoxiao.search.dao;

import com.chengxiaoxiao.search.pojo.Articel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Cheng Xiaoxiao
 */
public interface ArticelSearchDao extends ElasticsearchRepository<Articel, String> {

    /**
     * 根据标题和内容搜索
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Articel> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
