package com.funs.core.base.model;


/**
 * 查询条件VO
 * 
 * @author jcchen
 * 
 */
public class QueryVO {

	private int pageNo = 1;
	private int pageSize;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageFrom() {
		return (pageNo - 1) * pageSize;
	}
}
