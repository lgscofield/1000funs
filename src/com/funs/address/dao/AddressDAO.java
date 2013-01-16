/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.address.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funs.address.model.AddressVO;
import com.funs.address.model.RegionVO;
import com.funs.core.base.dao.BaseDAO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class AddressDAO extends BaseDAO {

	public List<RegionVO> queryChildRegionById(int currentRegionId) {
		return this.sqlSessionTemplate.selectList("com.funs.address.queryChildRegionById", currentRegionId);
	}
	
	public List<AddressVO> queryAddress(int currentRegionId,String userInput){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("currentRegionId",currentRegionId);
		paramMap.put("userInput", userInput);
		return this.sqlSessionTemplate.selectList("com.funs.address.queryAddress",paramMap);
	}
	
	public void addTempAddress(AddressVO tempAddressVO){
		 this.sqlSessionTemplate.insert("com.funs.address.addTempAddress",tempAddressVO);
	}
}
