package com.chris.CkSearchE.entrance;

import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.config.destFactory.KafkaConfig;
import com.chris.CkSearchE.config.destFactory.RabbitMQConfig;
import com.chris.CkSearchE.config.sourceFactory.HbaseConfig;
import com.chris.CkSearchE.config.sourceFactory.JdbcConfig;
import com.chris.CkSearchE.input.ReadHBaseStrategy;
import com.chris.CkSearchE.input.ReadJdbcStrategy;
import com.chris.CkSearchE.output.WriteKafkaStrategy;
import com.chris.CkSearchE.output.WriteRabbitMQStrategy;

public class ExtractToolFactory {
	
	public static ExtractTool create(EToolConfig config){
		if(config.getSourceConfig() instanceof JdbcConfig){
			if(config.getDestConfig() instanceof KafkaConfig){
				return new ExtractTool(new ReadJdbcStrategy(config), new WriteKafkaStrategy(config));
			}else if(config.getDestConfig() instanceof RabbitMQConfig){
				return new ExtractTool(new ReadJdbcStrategy(config), new WriteRabbitMQStrategy(config));
			}
		}else if(config.getSourceConfig() instanceof HbaseConfig){
			if(config.getDestConfig() instanceof KafkaConfig){
				return new ExtractTool(new ReadHBaseStrategy(config), new WriteKafkaStrategy(config));
			}else if(config.getDestConfig() instanceof RabbitMQConfig){
				return new ExtractTool(new ReadHBaseStrategy(config), new WriteRabbitMQStrategy(config));
			}
		}
		
		return null;
	}

}
