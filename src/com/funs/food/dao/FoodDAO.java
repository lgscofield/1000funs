/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.funs.core.base.dao.BaseDAO;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodQueryCondition;
import com.funs.food.model.FoodVO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class FoodDAO extends BaseDAO {

	public int insertFood(FoodVO foodVO) {
		this.sqlSessionTemplate.insert("com.funs.food.insertFood", foodVO);
		return foodVO.getId();
	}
	
	public int queryIdForFoodVO(FoodVO foodVO) {
		return this.sqlSessionTemplate.selectOne("com.funs.food.queryIdForFoodVO", foodVO);
	}
	
	public int insertFoodReShop(FoodVO foodVO){
		return this.sqlSessionTemplate.insert("com.funs.food.insertFoodReShop", foodVO);
	}
	
	/**
	 * 新增分组信息
	 * @param foodGroupVO
	 * @return id
	 */
	public int insertFoodGroup(FoodGroupVO foodGroupVO){
		this.sqlSessionTemplate.insert("com.funs.food.insertFoodGroup",foodGroupVO);
		return foodGroupVO.getId();
	}
	
	/**
	 * 更新分组信息
	 * @param foodGroupVO
	 * @return
	 */
	public int updateGroup(FoodGroupVO foodGroupVO) {
		return this.sqlSessionTemplate.update("com.funs.food.updateGroup", foodGroupVO);
	}
	
	/**
	 * 更新食品信息
	 * @param foodVO
	 * @return
	 */
	public int updateFood(FoodVO foodVO) {
		return this.sqlSessionTemplate.update("com.funs.food.updateFood", foodVO);
	}
	
	public int deleteGroup(int id) {
		return this.sqlSessionTemplate.update("com.funs.food.deleteGroup", id);
	}
	
	public int deleteFood(int id) {
		return this.sqlSessionTemplate.update("com.funs.food.deleteFood", id);
	}
	
	public List<FoodVO> queryFoodsByShopId(int shopId){
		List<FoodVO> result =  this.sqlSessionTemplate.selectList("com.funs.food.queryFoodsByShopId", shopId);
		return result;
	}
	
	public int queryCountOfFood(){
		return this.sqlSessionTemplate.selectOne("com.funs.food.queryCountOfFood");
	}
	
	/**
	 * 查询所有分组及食物的信息(包括空分组)
	 * @param foodQueryCondition
	 * @return
	 */
	public Map<String, List<FoodVO>> queryAllGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		List<FoodVO> foods = this.sqlSessionTemplate.selectList("com.funs.food.queryAllGroupAndFoods", foodQueryCondition);
		return transferFoodVOToMap(foods);
	}
	
	/**
	 * 查询可用的分组及食物信息(不包含空分组)
	 * @param foodQueryCondition
	 * @return
	 */
	public Map<String, List<FoodVO>> queryAvailableGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		List<FoodVO> foods = this.sqlSessionTemplate.selectList("com.funs.food.queryAvailableGroupAndFoods", foodQueryCondition);
		return transferFoodVOToMap(foods);
	}
	
	/**
	 * transfer the FoodVO to Map<String, List<FoodVO>>
	 * @param foods
	 * @return
	 */
	private Map<String, List<FoodVO>> transferFoodVOToMap(List<FoodVO> foods) {
		Map<String, List<FoodVO>> result = new LinkedHashMap<String, List<FoodVO>>();
		for(FoodVO food : foods) {
			String groupName = food.getGroupName();
			if(result.get(groupName) == null) 
				result.put(groupName, new ArrayList<FoodVO>());
			if(food.getId() != 0) 
				result.get(groupName).add(food);
		}
		return result;
	}
	
	public List<FoodGroupVO> queryGroups(int type) {
		List<FoodGroupVO> result = this.sqlSessionTemplate.selectList("com.funs.food.queryGroups", type);
		return result;
	}
	
	public List<FoodGroupVO> queryAllGroups() {
		List<FoodGroupVO> result = this.sqlSessionTemplate.selectList("com.funs.food.queryAllGroups");
		return result;
	}
	
	/**
	 * 查询单品食物
	 * @return
	 */
	public List<FoodVO> querySingleFoods(FoodQueryCondition queryCondition) {
		List<FoodVO> foods = this.sqlSessionTemplate.selectList("com.funs.food.querySingleFoods", queryCondition);
		return foods;
	}
	
	/**
	 * 查询单品食物的总数
	 * @return
	 */
	public int querySingleFoodsCount() {
		int ret = this.sqlSessionTemplate.selectOne("com.funs.food.querySingleFoodsCount");
		return ret;
	}
}
