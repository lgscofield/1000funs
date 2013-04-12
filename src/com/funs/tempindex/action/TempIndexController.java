package com.funs.tempindex.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 临时首页控制器
 
function			method				url
---------			------				--------
每日菜单设置			GET					/tempindex/setmenu

 * 
 * @author xchen
 *
 */
@Controller
@RequestMapping("/tempindex")
public class TempIndexController {
	
	@RequestMapping("/setmenu")
	public String setMenu(HttpServletRequest request) {
		ServletContext application = request.getSession().getServletContext();
		application.setAttribute("price1", request.getAttribute("price1"));
		application.setAttribute("price2", request.getAttribute("price2"));
		//TODO ...
		application.setAttribute("mainfood1", request.getAttribute("mainfood1"));
		//TODO ...
		application.setAttribute("secondfood1", request.getAttribute("secondfood1"));
		//TODO ...
		return "/web/tempindex.jsp";
	}
	
}
