package com.njnu.demo1.Bean;

import java.io.Serializable;

/**
 * POJO Table Category
 * Serializable 序列化
 */
public class Category implements Serializable {
    private Integer id;
    private String category;
    private String remark;
    //alt+(fn)insert
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
