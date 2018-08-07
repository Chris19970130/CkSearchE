package com.chris.CkSearchE.entrance;

import java.util.concurrent.ArrayBlockingQueue;

import com.chris.CkSearchE.input.ReadSourceStrategy;
import com.chris.CkSearchE.input.data.entity.SRecord;
import com.chris.CkSearchE.output.WriteDestStrategy;

/**
 * 2018-08-06
 * 抽取流程工具类
 * @author 徐晨坤
 *
 */
public class ExtractTool {
	private ReadSourceStrategy readStrategy;
	private WriteDestStrategy writeStrategy;
	private final static int CAPACITY = 1000000;
	private ArrayBlockingQueue<SRecord> queue = new ArrayBlockingQueue<SRecord>(CAPACITY);
	
	public ExtractTool(ReadSourceStrategy readStrategy,WriteDestStrategy writeStrategy){
		this.readStrategy = readStrategy;
		this.writeStrategy = writeStrategy;
		this.readStrategy.setQueue(queue);
		this.writeStrategy.setQueue(queue);
	}
	
	private void read(){
		new Thread(readStrategy).start();
	}
	
	private void write(){
		new Thread(writeStrategy).start();
	}
	
	private void close(){
		readStrategy.close();
		writeStrategy.close();
	}
	
	public void execute(){
		read();
		write();
		close();
	}
	
}
