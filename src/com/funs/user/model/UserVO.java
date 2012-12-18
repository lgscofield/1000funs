/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.funs.user.model;

import com.funs.core.base.model.BaseVO;
import com.funs.core.util.tools.DataGenerator;

/**
 * @author Xingling Chen
 * @since JDK1.6
 * @history 2011-05-11 Xingling build
 */
public class UserVO extends BaseVO{

	private int id;

	private String userName;

	private String phone;

	private String email;

	private String registerTime;

	private int score;

	private double quota;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getQuota() {
		return quota;
	}

	public void setQuota(double quota) {
		this.quota = quota;
	}
	
	public static void main(String[] args) {
		UserVO user = (UserVO)DataGenerator.get(UserVO.class);
		System.out.println(user.toString());
	}

}
