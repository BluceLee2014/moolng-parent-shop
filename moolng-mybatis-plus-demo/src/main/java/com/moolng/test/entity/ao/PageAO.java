package com.moolng.test.entity.ao;

import lombok.Data;

/**
 * @author 306548063@qq.com
 * @Desc
 * @date 2020/6/7 17:41
 */
@Data
public class PageAO {

    private int pageSize;
    private int pageNo;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
