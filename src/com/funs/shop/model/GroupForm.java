package com.funs.shop.model;

public class GroupForm {

	private String groupName;
	private String detail;
	private int type;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "GroupForm [groupName=" + groupName + ", detail=" + detail
				+ ", type=" + type + "]";
	}
}
