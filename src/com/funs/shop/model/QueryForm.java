package com.funs.shop.model;

public class QueryForm {

	private int pageNo;
	private int pageSize;
	private int recordCount;
	private String keyword;
	private int overtime;

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
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getOvertime() {
		return overtime;
	}
	public int getPageCount() {
		int c = recordCount / pageSize;
		return recordCount % pageSize == 0 ? c : c+1;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	@Override
	public String toString() {
		return "QueryForm [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", recordCount" + recordCount + ", keyword=" + keyword 
				+ ", overtime=" + overtime + "]";
	}
}
