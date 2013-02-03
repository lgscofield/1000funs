/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.funs.core.base.action.BaseAction;
import com.funs.core.base.model.ResultVO;
import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodVO;
import com.funs.food.service.FoodService;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
public class FoodAction extends BaseAction {
	
	final static Logger LOGGER = LoggerFactory.getLogger(FoodService.class);
	
	static ApplicationContext context = null;
	
	static FoodService foodService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		foodService = (FoodService)context.getBean("FoodService");
	}
	
	/**
	 * 增加食物（同时指定到店铺）
	 * @param foodVO
	 */
	public ResultVO insertFood(FoodVO foodVO){
		try{
			foodService.insertFood(foodVO);
		}catch(Exception e){
			LOGGER.info("insertFood 出错："+e);
			return new ResultVO(e.toString());
		}
		return new ResultVO();
	}
	
	/**
	 * 增加食物分组
	 * @param foodGroupVO
	 */
	public ResultVO insertFoodGroup(FoodGroupVO foodGroupVO){
		try{
			 foodService.insertFoodGroup(foodGroupVO); 
		}catch(Exception e){
			LOGGER.info("insertFood 出错："+e);
			return new ResultVO(e.toString());
		}
		return new ResultVO();
	}
	
	/**
	 * 查询所有在架食物
	 * @return List<FoodVO>
	 */
	public List<FoodVO> queryFoods(){
		List<FoodVO> result = foodService.queryFoods();
		return result;
	}
	
}
