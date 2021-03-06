package com.chris.CkSearchE.config.sourceFactory;

import java.util.Properties;

import com.chris.CkSearchE.config.factory.Factory;
import com.chris.CkSearchE.config.factory.IConfig;
import com.chris.CkSearchE.exception.EToolConfigException;

public class SourceJdbcFactory extends Factory{

	@Override
	public IConfig createConfig(Properties config) throws EToolConfigException {
		return new JdbcConfig(config);
	}

}
