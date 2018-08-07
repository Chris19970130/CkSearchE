package com.chris.CkSearchE.config.sourceFactory;

import java.util.Properties;

import com.chris.CkSearchE.config.factory.Factory;
import com.chris.CkSearchE.exception.EToolConfigException;

/**
 * 工厂接口的实现工厂，用来生产数据源配置类
 * @author xck
 *
 */
public class SourceHBaseFactory extends Factory{
	@Override
	public HbaseConfig createConfig(Properties config) throws EToolConfigException {
		return new HbaseConfig(config);
	}

}
