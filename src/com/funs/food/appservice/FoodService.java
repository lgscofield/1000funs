/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.appservice;

import java.util.List;

import com.funs.food.dao.FoodDAO;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodVO;

/**
 * @author Xingling Chen
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class FoodService {

	private FoodDAO foodDAO;

	public void insertFood(FoodVO foodVO){
		
	}
	
	public void insertFoodGroup(FoodGroupVO foodGroupVO){
		
	}
	
	public List<FoodVO> queryFoods(){
		//TODO  get current shopId, then query it's foods.
		int shopId = 1;
		return foodDAO.queryFoodsByShopId(shopId);
	}

	public FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	
	
}
