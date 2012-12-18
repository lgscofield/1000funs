package com.funs.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.core.util.tools.DataGenerator;
import com.funs.user.appservice.UserAppService;
import com.funs.user.model.UserVO;

/**
 * @author Xingling Chen
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
public class Test extends ApplicationObjectSupport {
	
	static ApplicationContext context = null;
	
	static UserAppService userAppService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		System.out.println(context);
		userAppService = (UserAppService)context.getBean("UserService");
	}
	
	public UserVO doInsert() {
		UserVO userVO = (UserVO) DataGenerator.get(UserVO.class,11);
		userAppService.doInsert(userVO);
		return userVO;
	}

	public UserVO queryUserByName(String name) {
		return userAppService.doQuery(name);
	}
}
