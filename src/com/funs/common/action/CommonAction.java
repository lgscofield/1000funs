package com.funs.common.action;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.funs.common.model.EnvironmentInfoVO;
import com.funs.core.base.action.BaseAction;
import com.funs.user.model.UserVO;

/**
 * 公共管理类
 * @author Administrator
 *
 */
@RemoteProxy
public class CommonAction extends BaseAction {
	/**
	 * 获取当前用户
	 * @return 当前用户
	 */
	@RemoteMethod
	public UserVO getUser(){
		WebContext objWebContext = WebContextFactory.get();
		return ((EnvironmentInfoVO)objWebContext.getSession().getAttribute("environmentInfo")).getUser();
	}
}
