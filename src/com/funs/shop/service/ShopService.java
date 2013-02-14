package com.funs.shop.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodVO;
import com.funs.order.model.OrderVO;

/**
 * 店铺管理Service
 * @author jcchen
 *
 */
@Service
public class ShopService {

	/**
	 * 查询订单列表
	 * @return
	 */
	public List<OrderVO> queryOrderList() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		OrderVO vo = new OrderVO();
		vo.setAddress("深圳市福田区莲花路2075号香丽大厦二楼");
		vo.setPhone("15818501051");
		vo.setTotalPrice(13.0);
		
		
		System.out.println("[ShopService] queryOrderList !");
		return list;
	}
	
	/**
	 * 查询食物分类列表
	 * @return
	 */
	public List<FoodGroupVO> queryFoodGroups() {
		List<FoodGroupVO> list = new ArrayList<FoodGroupVO>();
		list.add(newFoodGroupVO("10元区", null));
		list.add(newFoodGroupVO("9元区", null));
		list.add(newFoodGroupVO("8元区", null));
		list.add(newFoodGroupVO("7元区", null));
		list.add(newFoodGroupVO("6元区", null));
		list.add(newFoodGroupVO("例汤区", null));
		list.add(newFoodGroupVO("小吃", null));
		list.add(newFoodGroupVO("饮品", null));
		return list;
	}
	
	/**
	 * 组装一个FoodGroupVO
	 * @param name
	 * @param img
	 * @return
	 */
	private FoodGroupVO newFoodGroupVO(String name, String img) {
		FoodGroupVO vo = new FoodGroupVO();
		vo.setGroupName(name);
		vo.setImage(img);
		return vo;
	}
	
	/**
	 * 配餐模式页面的所有食物列表;包括各个分组及其下的所有食物。
	 * @return
	 */
	public Map<String, List<FoodVO>> queryFoods() {
		Map<String, List<FoodVO>> res = new LinkedHashMap<String, List<FoodVO>>();
		res.put("10元区", generateFoodList("排骨", "web/img/paigu.jpg", 7));
		res.put("9元区", generateFoodList("菜心", "web/img/chaixin.jpg", 4));
		res.put("8元区", generateFoodList("苦瓜炒蛋", "web/img/kuguachaodang.jpg", 3));
		res.put("7元区", generateFoodList("", "", 0));
		res.put("6元区", generateFoodList("", "", 0));
		res.put("例汤区", generateFoodList("", "", 0));
		res.put("小吃", generateFoodList("", "", 0));
		res.put("饮品", generateFoodList("", "", 0));
		return res;
	}
	
	/**
	 * 生成一个食物分组列表,测试代码
	 * @param name
	 * @param img
	 * @param amount
	 * @return
	 */
	private List<FoodVO> generateFoodList(String name, String img, int amount) {
		List<FoodVO> list = new ArrayList<FoodVO>();
		FoodVO vo;
		for(int i = 0; i < amount; i++) {
			vo = new FoodVO();
			vo.setFoodName(name);
			vo.setImage(img);
			list.add(vo);
		}
		return list;
	}
}
