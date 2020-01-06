package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

@Table(name = "y_category")
public class Category {
    /**
     * 类别id
     */
    @Id
    @Column(name = "catepory_id")
    private Integer cateporyId;

    /**
     * 类别名
     */
    @Column(name = "catepory_name")
    private String cateporyName;

    /**
     * 获取类别id
     *
     * @return catepory_id - 类别id
     */
    public Integer getCateporyId() {
        return cateporyId;
    }

    /**
     * 设置类别id
     *
     * @param cateporyId 类别id
     */
    public void setCateporyId(Integer cateporyId) {
        this.cateporyId = cateporyId;
    }

    /**
     * 获取类别名
     *
     * @return catepory_name - 类别名
     */
    public String getCateporyName() {
        return cateporyName;
    }

    /**
     * 设置类别名
     *
     * @param cateporyName 类别名
     */
    public void setCateporyName(String cateporyName) {
        this.cateporyName = cateporyName == null ? null : cateporyName.trim();
    }
}