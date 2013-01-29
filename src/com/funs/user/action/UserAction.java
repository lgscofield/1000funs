package com.funs.user.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.core.util.tools.DataGenerator;
import com.funs.user.model.UserVO;
import com.funs.user.service.UserService;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
public class UserAction extends ApplicationObjectSupport {
	
	static ApplicationContext context = null;
	
	static UserService userService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		System.out.println(context);
		userService = (UserService)context.getBean("UserService");
	}
	
	public UserVO doInsert() {
		UserVO userVO = (UserVO) DataGenerator.get(UserVO.class,11);
		userService.doInsert(userVO);
		return userVO;
	}

	public UserVO queryUserByName(String name) {
		return userService.doQuery(name);
	}
	
	public UserVO getCurrentUser(HttpServletRequest request){
		//TODO 需要在登陆完成时设置值
		return (UserVO)request.getSession().getAttribute("current_user");
	}
}
