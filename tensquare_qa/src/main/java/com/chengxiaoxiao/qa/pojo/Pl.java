package com.chengxiaoxiao.qa.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cheng Xiaoxiao
 */
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {
    @Id
    private String labelid;
    @Id
    private String problemid;

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }
}
