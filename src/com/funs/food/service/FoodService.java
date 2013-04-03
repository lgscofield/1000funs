/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.base.service.BaseService;
import com.funs.core.util.tools.CodeGenerator;
import com.funs.food.dao.FoodDAO;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodQueryCondition;
import com.funs.food.model.FoodVO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class FoodService extends BaseService{

	final static Logger LOGGER = LoggerFactory.getLogger(FoodService.class);

	private FoodDAO foodDAO;
	
	/**
	 * 增加食物（不指定店铺）
	 * @param foodVO
	 */
	public int insertFood(FoodVO foodVO) {
		
		//生成食物编号
		/*int foodCount=foodDAO.queryCountOfFood();
		String foodCode = CodeGenerator.getCode(CodeGenerator.TYPE.FOOD,foodCount);
		foodVO.setCode(foodCode);*/
		
		return foodDAO.insertFood(foodVO);
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
	 * @return int id
	 */
	public int insertFoodGroup(FoodGroupVO foodGroupVO) {
		return foodDAO.insertFoodGroup(foodGroupVO);
	}
	
	/**
	 * 更新分组信息
	 * @param foodGroupVO
	 * @return
	 */
	public int updateGroup(FoodGroupVO foodGroupVO) {
		return foodDAO.updateGroup(foodGroupVO);
	}
	
	/**
	 * 更新食品信息
	 * @param foodVO
	 * @return
	 */
	public int updateFood(FoodVO foodVO) {
		return foodDAO.updateFood(foodVO);
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
	
	public Map<String, List<FoodVO>> queryAllGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		return foodDAO.queryAllGroupAndFoods(foodQueryCondition);
	}
	
	public Map<String, List<FoodVO>> queryAvailableGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		return foodDAO.queryAvailableGroupAndFoods(foodQueryCondition);
	}
	
	public List<FoodGroupVO> queryGroups(int type) {
		return foodDAO.queryGroups(type);
	}
	
	public List<FoodGroupVO> queryAllGroups() {
		return foodDAO.queryAllGroups();
	}
	
	public int deleteGroup(int id) {
		return foodDAO.deleteGroup(id);
	}
	
	public int deleteFood(int id) {
		return foodDAO.deleteFood(id);
	}
	
	/**
	 * 查询单品食物
	 * @return
	 */
	public List<FoodVO> querySingleFoods(FoodQueryCondition queryCondition) {
		return foodDAO.querySingleFoods(queryCondition);
	}
	
	/**
	 * 查询单品食物的总数
	 * @return
	 */
	public int querySingleFoodsCount() {
		return foodDAO.querySingleFoodsCount();
	}

	public FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

}
