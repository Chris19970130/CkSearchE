package com.chris.CkSearchE.config.destFactory;

import java.util.Properties;

import com.chris.CkSearchE.config.factory.Factory;
import com.chris.CkSearchE.config.factory.IConfig;
import com.chris.CkSearchE.exception.EToolConfigException;

public class DestKafkaFactory extends Factory{


	@Override
	public IConfig createConfig(Properties config) throws EToolConfigException {
		return new KafkaConfig(config);
	}

}
