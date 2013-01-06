/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.funs.food.model;

import com.funs.core.base.model.BaseVO;
import com.funs.core.util.tools.DataGenerator;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2013-01-06 Xingling build
 */
public class FoodVO extends BaseVO{

	private int id;

	private String code;

	private String foodName;

	private String detail;

	private String image;

	private int shop_id;

	private int group_id;

	private double originPrice;
	
	private double currentPrice;
	
	private int stock;
	
	private boolean droped;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getShop_id() {
		return shop_id;
	}


	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}


	public int getGroup_id() {
		return group_id;
	}


	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}


	public double getOriginPrice() {
		return originPrice;
	}


	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}


	public double getCurrentPrice() {
		return currentPrice;
	}


	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public boolean isDroped() {
		return droped;
	}


	public void setDroped(boolean droped) {
		this.droped = droped;
	}


	public static void main(String[] args) {
		FoodVO food = (FoodVO)DataGenerator.get(FoodVO.class);
		System.out.println(food.toString());
	}

}
