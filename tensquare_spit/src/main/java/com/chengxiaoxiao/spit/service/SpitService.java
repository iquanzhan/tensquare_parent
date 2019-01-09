package com.chengxiaoxiao.spit.service;

import com.chengxiaoxiao.spit.dao.SpitDao;
import com.chengxiaoxiao.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: SpitService
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-01-09
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 查询全部记录
     *
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据ID获取记录
     *
     * @param id
     * @return
     */
    public Spit findById(String id) {
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    /**
     * 增加实体
     *
     * @param spit
     */
    public void add(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());
        spit.setComment(0);
        spit.setShare(0);
        spit.setThumbup(0);
        spit.setVists(0);
        spit.setState("1");
        if(spit.getParentId()!=null){
            //为评论
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentId()));
            Update update = new Update();
            update.inc("thumbup",1);
            mongoTemplate.updateFirst(query,update,"spit");

        }
        spitDao.save(spit);
    }

    /**
     * 更新实体
     *
     * @param spit
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 根据主键删除实体
     *
     * @param id
     */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据父ID分页查询
     *
     * @param parentId
     * @param page
     * @param size
     * @return
     */
    public Page<Spit> findByParentId(String parentId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return spitDao.findByParentId(parentId, pageable);
    }


    /**
     * 点赞
     *
     * @param id
     */
    public void updateThumbup(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }


}
