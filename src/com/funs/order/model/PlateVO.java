package com.funs.order.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 餐盘实体
 * @author jcchen
 *
 */
public class PlateVO {

	/**
	 * 餐盘号
	 */
	private int no;
	
	/**
	 * 食物列表
	 */
	private List<OrderFoodView> foodList = new ArrayList<OrderFoodView>();
	
	public PlateVO() {
	}
	
	public PlateVO(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * 获取餐盘总价
	 * @return
	 */
	public double getPrice() {
		double price = 0.0;
		for(OrderFoodView food : foodList) 
			price += food.getTotalPrice();
		return price;
	}
	public List<OrderFoodView> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<OrderFoodView> foodList) {
		this.foodList = foodList;
	}
	public void addFood(OrderFoodView food) {
		foodList.add(food);
	}
	@Override
	public String toString() {
		return "PlateVO [no=" + no + ", foodList="
				+ foodList + "]";
	}
}
