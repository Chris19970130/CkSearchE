package com.chris.CkSearchE.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ProducerTest extends TestCase{
	private   Properties properties = new Properties();
	
	@Before
	public void setUp(){
		properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "1");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	}
	
	@Test
	public void test(){
		Producer<String, String> producer = null;
		try{
			producer = new KafkaProducer<>(properties);
			for(int i = 0;i<100;i++){
				String msg = "Message" + i;
				producer.send(new ProducerRecord<String, String>("test", msg));
				System.out.println("sent "+msg);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			producer.close();
		}
		
	}

}
