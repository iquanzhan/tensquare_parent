package com.chengxiaoxiao.search.service;

import com.chengxiaoxiao.search.dao.ArticelSearchDao;
import com.chengxiaoxiao.search.pojo.Articel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import util.IdWorker;

/**
 * @author Cheng Xiaoxiao
 */
@Service
public class ArticelService {

    @Autowired
    ArticelSearchDao articelSearchDao;
    @Autowired
    IdWorker idWorker;

    public void add(Articel articel) {
        articel.setId(idWorker.nextId() + "");
        articel.setState("1");
        articelSearchDao.save(articel);
    }

    public Page<Articel> findByTitleOrContentLike(String keywords, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articelSearchDao.findByTitleOrContentLike(keywords, keywords, pageable);
    }

}
