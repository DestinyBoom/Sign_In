package com.boom.utils;

import java.util.List;

/**
 * 分页返回类
 * @author Administrator
 *
 */
public class PageResult {
    
	private long total;
    
	private int pageNumber = Const.PAGE;
    
	private List<?> rows;
    
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
   
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
