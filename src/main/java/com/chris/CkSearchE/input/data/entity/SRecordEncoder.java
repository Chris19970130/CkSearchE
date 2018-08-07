package com.chris.CkSearchE.input.data.entity;

import com.google.gson.Gson;

public class SRecordEncoder {
	private Gson gs = new Gson();
	
	public String encode(SRecord record){
		return gs.toJson(record);
	}

}
