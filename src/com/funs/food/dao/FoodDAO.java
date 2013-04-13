/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.food.dao;

import java.util.ArrayList;
import java.util.List;

import com.funs.core.base.dao.BaseDAO;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodQueryCondition;
import com.funs.food.model.FoodVO;
import com.funs.food.model.GroupFoods;
import com.funs.food.model.PackageItemVO;

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
		return (Integer)this.sqlSessionTemplate.selectOne("com.funs.food.queryIdForFoodVO", foodVO);
	}
	
	public FoodVO getFood(int id) {
		return (FoodVO)this.sqlSessionTemplate.selectOne("com.funs.food.getFood", id);
	}
	
	public int insertFoodReShop(FoodVO foodVO){
		return (Integer)this.sqlSessionTemplate.insert("com.funs.food.insertFoodReShop", foodVO);
	}
	
	public int insertPackageItem(PackageItemVO packageItemVO) {
		this.sqlSessionTemplate.insert("com.funs.food.insertPackageItem", packageItemVO);
		return packageItemVO.getId();
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
	
	/**
	 * 删除食物关联
	 * @param foodId 食物ID
	 * @return 成功删除的条数
	 */
	public int deleteFoodReShop(int foodId) {
		int shopId = 1; //TODO:从环境中取shopId
		FoodVO foodVO = new FoodVO();
		foodVO.setId(foodId);
		foodVO.setShopId(shopId);
		return this.sqlSessionTemplate.delete("com.funs.food.deleteFoodReShop", foodVO);
	}
	
	/**
	 * 删除套餐关联
	 * @param packageId 套餐id
	 * @return 成功删除的条数
	 */
	public int deletePackageItem(int packageId) {
		return this.sqlSessionTemplate.delete("com.funs.food.deletePackageItem", packageId);
	}
	
	public List<FoodVO> queryFoodsByShopId(int shopId){
		List<FoodVO> result =  this.sqlSessionTemplate.selectList("com.funs.food.queryFoodsByShopId", shopId);
		return result;
	}
	
	public int queryCountOfFood(){
		return (Integer)this.sqlSessionTemplate.selectOne("com.funs.food.queryCountOfFood");
	}
	
	/**
	 * 查询所有分组及食物的信息(包括空分组)
	 * @param foodQueryCondition
	 * @return
	 */
	public List<GroupFoods> queryAllGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		List<FoodVO> foods = this.sqlSessionTemplate.selectList("com.funs.food.queryAllGroupAndFoods", foodQueryCondition);
		return transferFoodVOToGroupFoods(foods);
	}
	
	/**
	 * 查询可用的分组及食物信息(不包含空分组)
	 * @param foodQueryCondition
	 * @return
	 */
	public List<GroupFoods> queryAvailableGroupAndFoods(FoodQueryCondition foodQueryCondition) {
		List<FoodVO> foods = this.sqlSessionTemplate.selectList("com.funs.food.queryAvailableGroupAndFoods", foodQueryCondition);
		return transferFoodVOToGroupFoods(foods);
	}
	
	/**
	 * transfer the FoodVO to Map<String, List<FoodVO>>
	 * @param foods
	 * @return
	 */
	private List<GroupFoods> transferFoodVOToGroupFoods(List<FoodVO> foods) {
		List<GroupFoods> lst = new ArrayList<GroupFoods>();
		int oldGroupId = 0;
		GroupFoods groupFoods = null;
		for(FoodVO food : foods) {
			int groupId = food.getGroupId();
			if(groupId != oldGroupId) {
				// reset oldid
				oldGroupId = groupId;
				
				groupFoods = new GroupFoods();
				groupFoods.setId(groupId);
				groupFoods.setGroupName(food.getGroupName());
				groupFoods.setImage(food.getGroupImage());
				groupFoods.setDetail(food.getGroupDetail());
				lst.add(groupFoods);
			}
			if(food.getId() != 0) groupFoods.addFood(food);
		}
		// add last one
		if(groupFoods != null && !lst.contains(groupFoods)) lst.add(groupFoods);
		return lst;
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
	 * 查询可用食物(每种食物在每个店铺只能被添加一次)
	 * @return
	 */
	public List<FoodVO> queryAvailableFoods(FoodQueryCondition queryCondition) {
		List<FoodVO> foods = this.sqlSessionTemplate.selectList("com.funs.food.queryAvailableFoods", queryCondition);
		return foods;
	}
	
	/**
	 * 查询单品食物的总数
	 * @return
	 */
	public int querySingleFoodsCount() {
		int ret = (Integer)this.sqlSessionTemplate.selectOne("com.funs.food.querySingleFoodsCount");
		return ret;
	}
}
