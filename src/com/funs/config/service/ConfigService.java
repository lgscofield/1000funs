package com.funs.config.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.config.dao.ConfigDAO;
import com.funs.config.model.ConfigVO;
import com.funs.food.service.FoodService;

public class ConfigService {

	final static Logger LOGGER = LoggerFactory.getLogger(FoodService.class);

	private ConfigDAO configDAO;
	
	public ConfigDAO getConfigDAO() {
		return configDAO;
	}

	public void setConfigDAO(ConfigDAO configDAO) {
		this.configDAO = configDAO;
	}

	/**
	 * 插入配置信息
	 * @param configVO
	 * @return
	 */
	public int insertConfig(ConfigVO configVO) {
		return configDAO.insertConfig(configVO);
	}
	
	/**
	 * 更新配置信息
	 * @param configVO
	 * @return
	 */
	public int updateConfig(ConfigVO configVO) {
		return configDAO.updateConfig(configVO);
	}
	
	/**
	 * 获取一个配置值
	 * @param key
	 * @return
	 */
	public ConfigVO getConfig(String key) {
		return configDAO.getConfig(key);
	}
	
}
