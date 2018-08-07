package com.chris.CkSearchE.engine;

import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.entrance.ExtractTool;
import com.chris.CkSearchE.entrance.ExtractToolFactory;

public class ExtractEngine {
	private EToolConfig config;
	private ExtractTool extractTool;
	
	public ExtractEngine(EToolConfig config){
		this.setConfig(config);
		extractTool = ExtractToolFactory.create(config);
	}
	
	public void start(){
		extractTool.execute();
	}

	public EToolConfig getConfig() {
		return config;
	}

	public void setConfig(EToolConfig config) {
		this.config = config;
	}

}
