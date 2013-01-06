/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
	本软件由千方百味公司开发
*****************************************************************************/
package com.funs.core.base.model;

import com.funs.core.util.tools.JsonUtil;


/**
 * VO基础类
 *
 * @author 黄科林
 * @since jdk6.0
 * @version  2012-12-15 
 * 
 */
public class BaseVO {
	
	public String toString() {
		return JsonUtil.objectToJson(this) ;
	}
}
