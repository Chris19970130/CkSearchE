package com.chris.CkSearchE.entrance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.engine.ExtractEngine;
import com.chris.CkSearchE.exception.EToolConfigException;

/**
 * 2018-08-01
 * 抽取工具入口类
 * @author 徐晨坤
 *
 */
public class ExtractEntrance {
	public static void main(String[] args) {
		EToolConfig config;
		try {
			config = new EToolConfig(loadConfig("config/config.ini"));
			ExtractEngine extractEngine = new ExtractEngine(config);
			extractEngine.start();
		} catch (EToolConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(args.length == 2){
//			try {
//				EToolConfig config = new EToolConfig(loadConfig(args[1]));
//				if(args[0].contains("-I")){
//					ExtractEngine extractEngine = new ExtractEngine(config);
//					extractEngine.start();
//				}else{
//					
//				}
//			} catch (EToolConfigException e) {
//				System.out.println(e.getMessage());
//			}
//		}else{
//			System.out.println("命令行格式:-command configFilePath");
//		}
	}
	
	public static Properties loadConfig(String fileName){
		Properties config = new Properties();
		File configFile = new File(fileName).getAbsoluteFile();
		
		try {
			config.load(new FileInputStream(configFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return config;
	}

}
