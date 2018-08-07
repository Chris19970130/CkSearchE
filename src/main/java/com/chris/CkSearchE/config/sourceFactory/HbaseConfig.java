package com.chris.CkSearchE.config.sourceFactory;

import java.util.Properties;

import com.chris.CkSearchE.config.factory.IConfig;
import com.chris.CkSearchE.exception.EToolConfigException;


/**
 * 2018-08-02
 * IConfig接口的实现类，保存HBase配置信息，未实现暂时保留
 * @author 徐晨坤
 *
 */
public class HbaseConfig implements IConfig{
	
	protected HbaseConfig(Properties config) throws EToolConfigException{
		
	}

}
