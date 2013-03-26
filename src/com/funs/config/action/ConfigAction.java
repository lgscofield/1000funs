package com.funs.config.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funs.config.model.ConfigVO;
import com.funs.config.service.ConfigService;

@Controller
public class ConfigAction {

	@Autowired
	private ConfigService configService;
	
	/**
	 * 插入配置信息
	 * @param configVO
	 * @return
	 */
	public int insertConfig(ConfigVO configVO) {
		return configService.insertConfig(configVO);
	}
	
	/**
	 * 更新配置信息
	 * @param configVO
	 * @return
	 */
	public int updateConfig(ConfigVO configVO) {
		return configService.updateConfig(configVO);
	}
	
	/**
	 * 获取一个配置值
	 * @param key
	 * @return
	 */
	public ConfigVO getConfig(String key) {
		return configService.getConfig(key);
	}
	
	@RequestMapping("/config/test")
	public @ResponseBody ConfigVO test(@RequestParam String key) {
		ConfigVO vo = getConfig(key);
		System.out.println(vo);
		return vo;
	}
}
