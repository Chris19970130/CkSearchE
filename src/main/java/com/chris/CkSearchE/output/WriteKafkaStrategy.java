package com.chris.CkSearchE.output;

import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.config.destFactory.KafkaConfig;
import com.chris.CkSearchE.input.data.entity.SRecord;
import com.chris.CkSearchE.output.data.kafka.KafkaDestWriter;

public class WriteKafkaStrategy extends WriteDestStrategy{
	
	public WriteKafkaStrategy(EToolConfig config) {
		this.config = config;
	}

	@Override
	public void write() {
		KafkaDestWriter destWriter = new KafkaDestWriter((KafkaConfig)config.getDestConfig());
		try {
			while(true){
				SRecord record = queue.take();
				destWriter.writeRecord(record);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		write();
	}

}
