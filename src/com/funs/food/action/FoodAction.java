/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.action;

import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.funs.core.base.action.BaseAction;
import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodQueryCondition;
import com.funs.food.model.FoodVO;
import com.funs.food.model.GroupFoods;
import com.funs.food.service.FoodService;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
@Controller
@RemoteProxy
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
	public int insertFood(FoodVO foodVO){
		try{
			return foodService.insertFood(foodVO);
		}catch(Exception e){
			LOGGER.info("insertFood 出错："+e);
		}
		return 0;
	}
	
	public FoodVO getFood(int id) {
		return foodService.getFood(id);
	}
	
	public int insertFoodReShop(FoodVO foodVO){
		return foodService.insertFoodReShop(foodVO);
	}
	
	/**
	 * 增加食物分组
	 * @param foodGroupVO
	 * @return int id
	 */
	public int insertFoodGroup(FoodGroupVO foodGroupVO){
		try{
			return foodService.insertFoodGroup(foodGroupVO); 
		}catch(Exception e){
			LOGGER.info("insertFood 出错："+e);
		}
		return 0;
	}
	
	/**
	 * 更新分组信息
	 * @param foodGroupVO
	 * @return
	 */
	public int updateGroup(FoodGroupVO foodGroupVO) {
		return foodService.updateGroup(foodGroupVO);
	}
	
	/**
	 * 更新食品信息
	 * @param foodVO
	 * @return
	 */
	public int updateFood(FoodVO foodVO) {
		return foodService.updateFood(foodVO);
	}
	
	/**
	 * 查询所有在架食物单品
	 * @return List<FoodVO>
	 */
	@RemoteMethod
	public List<FoodVO> queryFoods(){
		List<FoodVO> result = foodService.queryFoods();
		return result;
	}
	
	@RemoteMethod
	public List<GroupFoods> queryAllGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		return foodService.queryAllGroupAndFoods(foodQueryCondition);
	}
	
	public List<GroupFoods> queryAvailableGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		return foodService.queryAvailableGroupAndFoods(foodQueryCondition);
	}
	
	@RemoteMethod
	public List<FoodGroupVO> queryGroups(int type) {
		return foodService.queryGroups(type);
	}
	
	/**
	 * 查询所有分组信息
	 * @return
	 */
	public List<FoodGroupVO> queryAllGroups() {
		return foodService.queryAllGroups();
	}
	
	/**
	 * 删除分组
	 * @param id
	 * @return
	 */
	public int deleteGroup(int id) {
		return foodService.deleteGroup(id);
	}
	
	/**
	 * 删除食物
	 * @param id
	 * @return
	 */
	public int deleteFood(int id) {
		return foodService.deleteFood(id);
	}
	
	/**
	 * 查询单品食物
	 * @return
	 */
	public List<FoodVO> querySingleFoods(FoodQueryCondition queryCondition) {
		return foodService.querySingleFoods(queryCondition);
	}
	
	/**
	 * 查询可用食物(每种食物在每个店铺只能被添加一次)
	 * @return
	 */
	public List<FoodVO> queryAvailableFoods(FoodQueryCondition queryCondition) {
		return foodService.queryAvailableFoods(queryCondition);
	}
	
	/**
	 * 查询单品食物的总数
	 * @return
	 */
	public int querySingleFoodsCount() {
		return foodService.querySingleFoodsCount();
	}
}
