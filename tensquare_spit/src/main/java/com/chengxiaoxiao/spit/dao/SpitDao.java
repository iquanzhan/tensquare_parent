package com.chengxiaoxiao.spit.dao;

import com.chengxiaoxiao.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: SpitDao
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-01-09
 */
public interface SpitDao extends MongoRepository<Spit, String> {
}
