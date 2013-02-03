/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.user.dao;

import com.funs.core.base.dao.BaseDAO;
import com.funs.user.model.UserVO;

/**
 * @author Xingling Chen
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class UserDAO extends BaseDAO {

	public void insertUser(UserVO userVO) {
		this.sqlSessionTemplate.insert("com.funs.user.insertUser", userVO);
	}
	
	public UserVO queryUserByName(String name){
		return (UserVO)this.sqlSessionTemplate.selectOne("com.funs.user.queryUserByName",name);
	}
	
	public UserVO queryUserByCodeOrEmailOrPhone(String account){
		return (UserVO)this.sqlSessionTemplate.selectOne("com.funs.user.queryUserByNameOrEmailOrPhone",account);
	}
	
}
