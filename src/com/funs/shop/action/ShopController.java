package com.funs.shop.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.funs.food.model.FoodVO;
import com.funs.packages.model.PackageVO;
import com.funs.shop.model.OrderViewVO;
import com.funs.shop.service.ShopService;


/**
 * 店铺管理控制器
 * 
 * @author jcchen
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String toIndex() {
		return "shop/index"; 
	}
	
	
	@RequestMapping("/todo")
	public String toToodo(Model model) {
		List<OrderViewVO> list = shopService.queryOrderList();
		model.addAttribute("orderList", list);
		return "shop/todo";
	}
	
	@RequestMapping("/history")
	public String toHistory(Model model) {
		List<OrderViewVO> list = shopService.queryOrderList();
		list.get(list.size()-1).setOrderStatus(2); //异常
		model.addAttribute("orderList", list);
		return "shop/history";
	}
	
	@RequestMapping("/catering")
	public String toCatering(Model model) {
		Map<String, List<FoodVO>> foodMaps = shopService.queryFoods();
		model.addAttribute("foodMaps", foodMaps);
		return "shop/catering";
	}
	
	@RequestMapping("/package")
	public String toPackage(Model model) {
		Map<String, List<PackageVO>> packageMaps = shopService.queryPackages();
		model.addAttribute("packageMaps", packageMaps);
		return "shop/package";
	}
	
}
