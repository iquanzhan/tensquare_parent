package com.chengxiaoxiao.recruit.dao;

import com.chengxiaoxiao.recruit.pojo.Recruit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 推荐职位
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 获取不为state的前12条数据
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
