package com.funs.config.dao;

import com.funs.config.model.ConfigVO;
import com.funs.core.base.dao.BaseDAO;

/**
 * 配置管理DAO
 * @author jcchen
 *
 */
public class ConfigDAO extends BaseDAO {
	
	/**
	 * 插入配置信息
	 * @param configVO
	 * @return
	 */
	public int insertConfig(ConfigVO configVO) {
		return this.sqlSessionTemplate.insert("com.funs.config.insertConfig", configVO);
	}

	/**
	 * 更新配置信息
	 * @param configVO
	 * @return
	 */
	public int updateConfig(ConfigVO configVO) {
		return this.sqlSessionTemplate.update("com.funs.config.updateConfig", configVO);
	}
	
	/**
	 * 获取一个配置值
	 * @param key
	 * @return
	 */
	public ConfigVO getConfig(String key) {
		return this.sqlSessionTemplate.<ConfigVO>selectOne("com.funs.config.getConfig", key);
	}
}
