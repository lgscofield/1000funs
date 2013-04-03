package com.funs.shop.model;

public class FoodReShopForm {

	private int shopId;
	private int foodId;
	private int groupId;
	private double originPrice;
	private double currentPrice;
	private int stock;
	private boolean droped;
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public double getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isDroped() {
		return droped;
	}
	public void setDroped(boolean droped) {
		this.droped = droped;
	}
	@Override
	public String toString() {
		return "FoodReShopForm [shopId=" + shopId + ", foodId=" + foodId
				+ ", groupId=" + groupId + ", originPrice=" + originPrice
				+ ", currentPrice=" + currentPrice + ", stock=" + stock
				+ ", droped=" + droped + "]";
	}
}
