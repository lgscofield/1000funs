package com.funs.shop.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.funs.food.model.FoodVO;
import com.funs.order.action.OrderAction;
import com.funs.order.model.OrderVOWithFood;
import com.funs.packages.model.PackageVO;
import com.funs.shop.model.OrderFoodView;
import com.funs.shop.model.OrderView;
import com.funs.shop.model.QueryForm;
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
	
	@Autowired
	private OrderAction orderAction;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String toIndex() {
		return "shop/index"; 
	}
	
	@RequestMapping("/todo")
	public String toToodo(Model model, @ModelAttribute QueryForm queryForm) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>\n"+queryForm+"\n<<<<<<<<<<<<<<<<<<");
		
		Map<String, String> condition = new HashMap<String, String>();
		List<OrderVOWithFood> list0 = orderAction.queryNewOrdersWithFood(condition);
		List<OrderView> list = transferOrderVOToView(list0);
		model.addAttribute("orderList", list);
		return "shop/todo";
	}
	
	@RequestMapping("/history")
	public String toHistory(Model model) {
		List<OrderView> list = shopService.queryOrderList();
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
	
	/**
	 * 将List<OrderVOWithFood>转换为List<OrderViewVO>
	 * @param list
	 * @return
	 */
	private List<OrderView> transferOrderVOToView(List<OrderVOWithFood> list) {
		List<OrderView> ret = new ArrayList<OrderView>();
		int oldOrderId = 0;
		OrderView view = null;
		for(OrderVOWithFood vo : list) {
			if(oldOrderId != vo.getId()) { // new
				oldOrderId = vo.getId();
				if(view != null) ret.add(view); //add the prior one
				view = new OrderView();
				view.setId(vo.getId());
				view.setAddress(vo.getAddress());
				view.setContact(vo.getContact());
				view.setCreateTime(vo.getCreateTime());
				view.setExceptTime(vo.getExceptTime());
				view.setOrderStatus(vo.getOrderStatus());
				view.setPhone(vo.getPhone());
				view.setTotalPrice(vo.getTotalPrice());
				List<OrderFoodView> foodList = new ArrayList<OrderFoodView>();
				view.setFoodList(foodList);
			}
			OrderFoodView foodView = new OrderFoodView();
			foodView.setFood(vo.getFoodName());
			foodView.setAmount(vo.getAmount());
			view.getFoodList().add(foodView);
		}
		ret.add(view); //add the last one
		return ret;
	}
}
