package com.chris.CkSearchE.config;

import java.util.Properties;

import com.chris.CkSearchE.exception.EToolConfigException;

/**
 * 2018-08-01
 * 数据表配置类
 * @author 徐晨坤
 *
 */
public class TableConfig {
	private final String name;//表名
	private final String term;//查询条件
	
	
	protected TableConfig(String name,String term){
		this.name = name;
		this.term = term;
	}
	
	protected TableConfig(Properties config) throws EToolConfigException{
		this.name = config.getProperty("table.name");
		this.term = config.getProperty("table.term", "");
		if(name == null){
			throw new EToolConfigException("配置信息错误:table.name缺失");
		}
	}


	public String getName() {
		return name;
	}


	public String getTerm() {
		return term;
	}


	@Override
	public String toString() {
		return "TableConfig [name=" + name + ", term=" + term + "]";
	}
	
	
	
}
