/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.user.appservice;

import org.codehaus.jackson.type.TypeReference;

import com.comtop.top.cfg.client.util.JsonCommonUtil;
import com.funs.user.dao.UserDAO;
import com.funs.user.model.UserVO;

/**
 * @author Xingling Chen
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class UserAppService {

	private UserDAO userDAO;

	public void doInsert(String jsonUser) {
		UserVO objUser = JsonCommonUtil.jsonToObject(jsonUser, new TypeReference<UserVO>(){});
		this.userDAO.doInsert(objUser);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO testImpl) {
		this.userDAO = testImpl;
	}
}
