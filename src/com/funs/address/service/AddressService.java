/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.address.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.address.dao.AddressDAO;
import com.funs.address.model.RegionVO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class AddressService {

	final static Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

	private AddressDAO addressDAO;
	
	/**
	 * 增加食物（不指定店铺）
	 * @param regionVO
	 */
	public List<RegionVO> queryChildRegion(int currentRegionId) {
		return addressDAO.queryChildRegionById(currentRegionId);
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
