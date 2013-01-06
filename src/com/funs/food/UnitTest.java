package com.funs.food;

import java.util.List;

import com.funs.core.base.model.ResultVO;
import com.funs.food.action.FoodAction;
import com.funs.food.model.FoodVO;

public class UnitTest {
	
	static FoodAction action = new FoodAction();
	
	/**
	 * FOR TEST
	 * init test datas
	 */
	public static void insertFood() {
		FoodVO foodVO = new FoodVO();
		String code = "2013F-00106-00001";
		foodVO.setCode(code);
		foodVO.setCurrentPrice(3.0);
		foodVO.setDetail("香喷喷，好吃又好看的西红柿炒鸡蛋");
		foodVO.setDroped(false);
		foodVO.setFoodName("西红柿炒鸡蛋");
		foodVO.setGroupId(1);
		foodVO.setImage("/web/images/"+code+".png");
		foodVO.setOriginPrice(4.0);
		foodVO.setShopId(1);
		foodVO.setStock(10);
		ResultVO result = action.insertFood(foodVO);
		System.out.println(result.isSuccess());
	}
	
	public static void queryFoods(){
		List<FoodVO> result = action.queryFoods();
		System.out.println(result.get(0).getFoodName());
	}
}
