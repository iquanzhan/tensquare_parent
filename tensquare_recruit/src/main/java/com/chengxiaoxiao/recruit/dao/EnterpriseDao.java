package com.chengxiaoxiao.recruit.dao;

import com.chengxiaoxiao.recruit.pojo.Enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {
    /**
     * 获取热门企业
     * @return
     */
    public List<Enterprise> findByIshot(String isHot);

}
