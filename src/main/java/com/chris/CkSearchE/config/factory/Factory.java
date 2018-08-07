package com.chris.CkSearchE.config.factory;

import java.util.Properties;

import com.chris.CkSearchE.exception.EToolConfigException;

/**
 * 2018-08-02
 * 配置文件抽象工厂接口
 * @author 徐晨坤
 *
 */
public abstract class Factory {
	/**
	 * 根据配置文件信息，生成配置类的接口方法
	 * @param config
	 * @return JdbcConfig
	 * @throws EToolConfigException
	 */
	public abstract IConfig createConfig(Properties config) throws EToolConfigException;
	

}
