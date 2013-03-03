package com.funs.shop.model;

public class QueryForm {

	private String keyword;
	private int overtime;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getOvertime() {
		return overtime;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	@Override
	public String toString() {
		return "QueryForm [keyword=" + keyword + ", overtime=" + overtime + "]";
	}
}
