package com.funs.food.model;

import org.directwebremoting.annotations.DataTransferObject;

import com.funs.core.base.model.BaseVO;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2013-1-6 Xingling build
 */
@DataTransferObject
public class FoodGroupVO extends BaseVO {
	private int id;
	private String groupName;
	private String image;
	private String detail;
	/**
	 * 类型: 1-food; 2-package
	 */
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

}
