package com.chengxiaoxiao.qa.dao;

import com.chengxiaoxiao.qa.pojo.Problem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    /**
     * 根据标签获取最新问题列表
     * @param labelId
     * @return
     */
    @Query(value = "SELECT p.* from tb_problem p JOIN tb_pl on tb_pl.problemid=p.id where labelid=? ORDER BY replytime DESC", nativeQuery = true)
    public Page<Problem> newList(String labelId, Pageable pageable);

    /**
     * 获取热门问题
     * @param labelId
     * @return
     */
    @Query(value = "SELECT p.* from tb_problem p JOIN tb_pl on tb_pl.problemid=p.id where labelid=? ORDER BY reply DESC", nativeQuery = true)
    public Page<Problem> hotList(String labelId, Pageable pageable);

    /**
     * 获取热门问题
     * @param labelId
     * @return
     */
    @Query(value = "SELECT p.* from tb_problem p JOIN tb_pl on tb_pl.problemid=p.id where labelid=? and reply=0 ORDER BY reply DESC", nativeQuery = true)
    public Page<Problem> waitList(String labelId, Pageable pageable);


}
