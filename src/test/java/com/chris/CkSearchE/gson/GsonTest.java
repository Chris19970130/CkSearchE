package com.chris.CkSearchE.gson;

import java.util.Date;

import com.chris.CkSearchE.input.data.entity.SField;
import com.chris.CkSearchE.input.data.entity.SRecord;
import com.google.gson.Gson;

import junit.framework.TestCase;

public class GsonTest extends TestCase{
	SRecord record = new SRecord();
	@Override
	protected void setUp() throws Exception {
		record.addField(new SField("test", "test"));
		record.addField(new SField("test2", 1));
		record.addField(new SField("test3", new Date()));
		record.addField(new SField("test4", "test4"));
		record.addField(new SField("test5", "test5"));

		record.setTableName("Test");
	}
	
	public void test(){
		Gson gs = new Gson();
		String res = gs.toJson(record);
		System.out.println(res);
		SRecord re = gs.fromJson(res, SRecord.class);
		System.out.println(re.getFieldValueByName("test3"));
	}

}
