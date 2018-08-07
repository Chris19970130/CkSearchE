package com.chris.CkSearchE.config.destFactory;

import java.util.Properties;

import com.chris.CkSearchE.config.factory.IConfig;
import com.chris.CkSearchE.exception.EToolConfigException;

/**
 * 2018-08-01
 * kafka配置类
 * @author 徐晨坤
 *
 */
public class KafkaConfig implements IConfig{
	private final String server;//kafka地址
	private final String acks;//设置kafka生产者收到确认的副本数,0表示不需要接受ack，1表示需要leader partition收到消息时得到broker的一个确认
	private final int retries;
	private final int batchSize;
	private final int linger;
	private final int buffer;
	private final String keySerializer;
	private final String valueSerializer;
	
	
	protected KafkaConfig(String server, String acks, int retries, int batchSize, int linger, int buffer,
			String keySerializer, String valueSerializer) {
		super();
		this.server = server;
		this.acks = acks;
		this.retries = retries;
		this.batchSize = batchSize;
		this.linger = linger;
		this.buffer = buffer;
		this.keySerializer = keySerializer;
		this.valueSerializer = valueSerializer;
	}
	
	protected KafkaConfig(Properties config) throws EToolConfigException{
		this.server = config.getProperty("kafka.server");
		this.acks = config.getProperty("kafka.acks","1");
		this.retries = Integer.parseInt(config.getProperty("kafka.retries", "0"));
		this.batchSize = Integer.parseInt(config.getProperty("kafka.batchSize", "16384"));
		this.linger = Integer.parseInt(config.getProperty("kafka.linger","1"));
		this.buffer = Integer.parseInt(config.getProperty("kafka.buffer","33554432"));
		this.keySerializer = config.getProperty("kafka.keySerializer","org.apache.kafka.common.serialization.StringSerializer");
		this.valueSerializer = config.getProperty("kafka.valueSerializer","org.apache.kafka.common.serialization.StringSerializer");
		
		if(this.server == null){
			throw new EToolConfigException("配置信息错误:kafka.server缺失");
		}
	}

	public String getServer() {
		return server;
	}

	public String getAcks() {
		return acks;
	}

	public int getRetries() {
		return retries;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public int getLinger() {
		return linger;
	}

	public int getBuffer() {
		return buffer;
	}

	public String getKeySerializer() {
		return keySerializer;
	}

	public String getValueSerializer() {
		return valueSerializer;
	}
	
}
