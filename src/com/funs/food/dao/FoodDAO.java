/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.dao;

import java.util.LinkedList;
import java.util.List;

import com.funs.core.base.dao.BaseDAO;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodVO;

/**
 * @author Xingling Chen
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class FoodDAO extends BaseDAO {

	public void insertFood(FoodVO foodVO) {
		this.sqlSessionTemplate.insert("com.funs.food.insertFood", foodVO);
	}
	
	public void insertFoodReShop(FoodVO foodVO){
		this.sqlSessionTemplate.insert("com.funs.food.insertFoodReShop", foodVO);
	}
	
	public void insertFoodGroup(FoodGroupVO foodGroupVO){
		this.sqlSessionTemplate.insert("com.funs.food.insertFoodGroup",foodGroupVO);
	}
	
	public List<FoodVO> queryFoodsByShopId(int shopId){
		List<Object> lstObjects =  this.sqlSessionTemplate.selectList("com.funs.food.queryFoodsByShopId", shopId);
		List<FoodVO> result = new LinkedList<FoodVO>();
		for(Object o:lstObjects){
			result.add((FoodVO)o);
		}
		return result;
	}
	
}
