package com.chris.CkSearchE.output;

import java.util.concurrent.ArrayBlockingQueue;

import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.input.data.entity.SRecord;

public abstract class WriteDestStrategy implements Runnable{
	protected EToolConfig config;
	protected ArrayBlockingQueue<SRecord> queue;
	
	public abstract void write();
	
	public abstract void close();

	public EToolConfig getConfig() {
		return config;
	}

	public void setConfig(EToolConfig config) {
		this.config = config;
	}
	
	
	public void setQueue(ArrayBlockingQueue<SRecord> queue){
		this.queue = queue;
	}

}
