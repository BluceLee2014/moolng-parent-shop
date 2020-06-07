package com.moolng.test.entity.ao;

import lombok.Data;

/**
 * @author 306548063@qq.com
 * @Desc
 * @date 2020/6/7 18:20
 */
@Data
public class UserAO extends BaseAO{

    private Long id;
    private String orderNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
