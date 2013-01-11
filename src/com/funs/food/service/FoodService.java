/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.util.tools.CodeGenerator;
import com.funs.food.dao.FoodDAO;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodVO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class FoodService {

	final static Logger LOGGER = LoggerFactory.getLogger(FoodService.class);

	private FoodDAO foodDAO;
	
	/**
	 * 增加食物（不指定店铺）
	 * @param foodVO
	 */
	public void insertFood(FoodVO foodVO) {
		
		//生成食物编号
		int foodCount=foodDAO.queryCountOfFood();
		String foodCode = CodeGenerator.getCode(CodeGenerator.TYPE.FOOD,foodCount);
		foodVO.setCode(foodCode);
		
		foodDAO.insertFood(foodVO);
	}
	
	/**
	 * 增加食物（同时指定到店铺）
	 * @param foodVO
	 */
	public void insertFoodWithShop(FoodVO foodVO) {
		
		//生成食物编号
		int foodCount=foodDAO.queryCountOfFood();
		String foodCode = CodeGenerator.getCode(CodeGenerator.TYPE.FOOD,foodCount);
		foodVO.setCode(foodCode);
		
		foodDAO.insertFood(foodVO);
		
		//获取新生成的食物id
		int foodId = foodDAO.queryIdForFoodVO(foodVO);
		foodVO.setId(foodId);
		
		//插入FoodReShop信息
		foodDAO.insertFoodReShop(foodVO);
	}

	/**
	 * 增加食物分组
	 * @param foodGroupVO
	 */
	public void insertFoodGroup(FoodGroupVO foodGroupVO) {
			foodDAO.insertFoodGroup(foodGroupVO);
	}

	/**
	 * 查询所有在架食物
	 * @return
	 */
	public List<FoodVO> queryFoods() {
		// TODO get current shopId, then query it's foods. transiently, use default value : 1
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
