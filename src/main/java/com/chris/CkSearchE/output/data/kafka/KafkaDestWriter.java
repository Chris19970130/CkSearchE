package com.chris.CkSearchE.output.data.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.chris.CkSearchE.config.destFactory.KafkaConfig;
import com.chris.CkSearchE.input.data.entity.SRecord;
import com.chris.CkSearchE.input.data.entity.SRecordEncoder;

/**
 * 2018-08-06
 * kafka写入器，将数据写入kafka
 * @author 徐晨坤
 *
 */
public class KafkaDestWriter {
	private Producer<String, String> producer;
	private KafkaConfig config;
	private SRecordEncoder encoder = new SRecordEncoder();
	
	public KafkaDestWriter(KafkaConfig config){
		this.config = config;
		init();
	}
	
	public void init(){
		Properties properties = new Properties();
		properties.put("bootstrap.servers", config.getServer());
        properties.put("acks", config.getAcks());
        properties.put("retries", config.getRetries());
        properties.put("batch.size", config.getBatchSize());
        properties.put("linger.ms", config.getLinger());
        properties.put("buffer.memory", config.getBuffer());
        properties.put("key.serializer", config.getKeySerializer());
        properties.put("value.serializer", config.getValueSerializer());
        producer = new KafkaProducer<>(properties);
	}
	
	public void writeRecord(SRecord record){
		producer.send(new ProducerRecord<String, String>("toolTest", encoder.encode(record)));
	}

}
