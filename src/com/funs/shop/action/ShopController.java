package com.funs.shop.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 店铺管理控制器
 * 
 * @author jcchen
 *
 */
@Controller
public class ShopController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/shop.ac")
	public String toIndex() {
		System.out.println(" RequestMapping :: /shop ");
		return "shop/index"; 
	}
	
	
	@RequestMapping("/shop/todo.ac")
	public String toToodo() {
		return "shop/todo";
	}
	
	@RequestMapping("/shop/history.ac")
	public String toHistory() {
		return "shop/history";
	}
	
	@RequestMapping("/shop/catering.ac")
	public String toCatering() {
		return "shop/catering";
	}
	
	@RequestMapping("/shop/package.ac")
	public String toPackage() {
		return "shop/package";
	}
	
}
