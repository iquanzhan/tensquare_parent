package com.chengxiaoxiao.base.dao;

import com.chengxiaoxiao.base.pojo.Label;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Cheng Xiaoxiao
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
