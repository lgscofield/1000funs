/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.address.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.funs.address.model.AddressVO;
import com.funs.address.model.RegionVO;
import com.funs.address.service.AddressService;
import com.funs.core.springmvc.ApplicationContextInitor;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
public class AddressAction extends ApplicationObjectSupport {
	
	final static Logger LOGGER = LoggerFactory.getLogger(AddressAction.class);
	
	static ApplicationContext context = null;
	
	static AddressService addressService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		addressService = (AddressService)context.getBean("AddressService");
	}
	
	/**
	 * 查询子区域
	 * @param currentRegionId
	 * @return List<RegionVO>
	 */
	public List<RegionVO> queryChildRegion(int currentRegionId){
		List<RegionVO> result = null;
		try{
			result = addressService.queryChildRegion(currentRegionId);
		}catch(Exception e){
			LOGGER.error("queryChildRegion 出错："+e);
		}
		return result;
	}
	
	public List<AddressVO> queryAddress(){
		List<AddressVO> result = null;
		try{
			result = null;
		}catch(Exception e){
			LOGGER.error("queryAddress 出错："+e);
		}
		return result;
	}
	
}
