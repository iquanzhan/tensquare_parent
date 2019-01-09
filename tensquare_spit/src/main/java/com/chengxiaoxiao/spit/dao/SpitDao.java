package com.chengxiaoxiao.spit.dao;

import com.chengxiaoxiao.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: SpitDao
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-01-09
 */
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 根据父Id查询本标签
     * @param parentId
     * @param pageable
     * @return
     */
    public Page<Spit> findByParentId(String parentId, Pageable pageable);
}
