/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.appservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.base.model.ResultVO;
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

	public void insertFood(FoodVO foodVO) {
		foodDAO.insertFood(foodVO);
		foodDAO.insertFoodReShop(foodVO);
	}

	public ResultVO insertFoodGroup(FoodGroupVO foodGroupVO) {
		try {
			foodDAO.insertFoodGroup(foodGroupVO);
		} catch (Exception e) {
			LOGGER.info("insertFoodGroup 出错：" + e);
			return new ResultVO(e.toString());
		}
		return new ResultVO();
	}

	public List<FoodVO> queryFoods() {
		// TODO get current shopId, then query it's foods.
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
