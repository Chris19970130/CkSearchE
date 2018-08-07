package com.chris.CkSearchE.config.sourceFactory;

import java.util.Properties;

import com.chris.CkSearchE.config.factory.IConfig;
import com.chris.CkSearchE.exception.EToolConfigException;

/**
 * 2018-08-02
 * IConfig接口的实现类，保存数据库配置信息
 * @author 徐晨坤
 *
 */
public class JdbcConfig implements IConfig{
	private final String url;
	private final String user;
	private final String pass;
	
	protected JdbcConfig(String url,String user,String pass){
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	protected JdbcConfig(Properties config) throws EToolConfigException{
		this.url = config.getProperty("jdbc.url");
		this.user = config.getProperty("jdbc.user");
		this.pass = config.getProperty("jdbc.pass");
		
		if(this.url == null){
			throw new EToolConfigException("配置信息错误:jdbc.url缺失");
		}
		
		if(this.user == null){
			throw new EToolConfigException("配置信息错误:jdbc.user缺失");
		}
		
		if(this.pass == null){
			throw new EToolConfigException("配置信息错误:jdbc.pass缺失");
		}
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public String toString() {
		return "JdbcConfig [url=" + url + ", user=" + user + ", pass=" + pass + "]";
	}

}
