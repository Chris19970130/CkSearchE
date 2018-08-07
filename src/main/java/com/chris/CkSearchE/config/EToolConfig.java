package com.chris.CkSearchE.config;

import java.util.Properties;

import com.chris.CkSearchE.config.destFactory.DestKafkaFactory;
import com.chris.CkSearchE.config.destFactory.DestRabbitMQFactory;
import com.chris.CkSearchE.config.factory.Factory;
import com.chris.CkSearchE.config.factory.IConfig;
import com.chris.CkSearchE.config.sourceFactory.SourceHBaseFactory;
import com.chris.CkSearchE.config.sourceFactory.SourceJdbcFactory;
import com.chris.CkSearchE.exception.EToolConfigException;
/**
 * 2018-08-02
 * 抽取工具全局配置类
 * @author 徐晨坤
 *
 */
public class EToolConfig {
	private IConfig sourceConfig;
	private TableConfig tableConfig;
	private IConfig destConfig;
	private String sourceType;
	private String destType;
	
	/**
	 * 2018-08-02
	 * 内部私有类，提供数据源类型常量
	 * @author 徐晨坤
	 *
	 */
	private class SourceType{
		public final static String JDBC = "jdbc";
		public final static String HBASE = "hbase";
	}
	
	private class DestType{
		public final static String KAFKA = "kafka";
		public final static String RABBITMQ = "rabbitmq";
	}
	
	public EToolConfig(Properties config) throws EToolConfigException{
		tableConfig = new TableConfig(config);
		this.sourceType = config.getProperty("sourceType");
		
		if(this.sourceType == null){
			throw new EToolConfigException("配置信息错误:数据源类型sourceType缺失");
		}
		
		this.destType = config.getProperty("destType");
		
		if(this.destType == null){
			throw new EToolConfigException("配置信息错误:输出源类型destType缺失");
		}
		
		
		Factory sourceFactory = null;
		if(SourceType.JDBC.equalsIgnoreCase(this.sourceType)){
			sourceFactory = new SourceJdbcFactory();
		}else if(SourceType.HBASE.equalsIgnoreCase(this.sourceType)){
			sourceFactory = new SourceHBaseFactory();
		}else{
			throw new EToolConfigException("配置信息错误:不支持的数据源类型type");
		}
		sourceConfig = sourceFactory.createConfig(config);
		
		Factory destFactory = null;
		if(DestType.KAFKA.equalsIgnoreCase(this.destType)){
			destFactory = new DestKafkaFactory();
		}else if(DestType.RABBITMQ.equalsIgnoreCase(this.destType)){
			destFactory = new DestRabbitMQFactory();
		}
		destConfig = destFactory.createConfig(config);
	}

	public IConfig getSourceConfig() {
		return sourceConfig;
	}

	public TableConfig getTableConfig() {
		return tableConfig;
	}

	public IConfig getDestConfig() {
		return destConfig;
	}
	
}
