package com.chris.CkSearchE.input;


import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.input.data.entity.SRecord;
import com.chris.CkSearchE.input.data.jdbc.JdbcSourceReader;

public class ReadJdbcStrategy extends ReadSourceStrategy{
	
	public ReadJdbcStrategy(EToolConfig config){
		this.config = config;
	}
	
	@Override
	public void readSource() {
		JdbcSourceReader srcReader = new JdbcSourceReader(config);
		try {
			SRecord record = srcReader.readRecord();
			while(record != null){
				queue.put(record);
				record = srcReader.readRecord();
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
		readSource();
	}

}
