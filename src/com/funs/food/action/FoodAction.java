package com.funs.food.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.funs.core.base.model.ResultVO;
import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.food.appservice.FoodService;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodVO;

/**
 * @author Xingling Chen
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
public class FoodAction extends ApplicationObjectSupport {
	
	static ApplicationContext context = null;
	
	static FoodService foodService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		foodService = (FoodService)context.getBean("FoodService");
	}
	
	public ResultVO insertFood(FoodVO foodVO){
		
		return null;
	}
	
	public ResultVO insertFoodGroup(FoodGroupVO foodGroupVO){
		
		return null; 
	}
	
	public List<FoodVO> queryFoods(){
		List<FoodVO> result = foodService.queryFoods();
		//TODO sysout for debug
		System.out.println("queryFoods:"+result);
		return result;
	}
	
}
