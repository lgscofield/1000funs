package com.funs.core.base.action;

public class QueryForm {

	public static final int SIZE_DEFAULT = 18;
	
	private int pageNo = 1;
	private int pageSize = 6;
	private int recordCount;
	
	public int getPageNo() {
		if(pageNo > getPageCount())
			return 1;
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
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		int c = recordCount / pageSize;
		return recordCount % pageSize == 0 ? c : c+1;
	}
}
