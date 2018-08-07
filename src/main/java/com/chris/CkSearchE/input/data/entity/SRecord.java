package com.chris.CkSearchE.input.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018-08-06
 * 对应于数据库表中的一条记录
 * @author 徐晨坤
 *
 */
public class SRecord implements Serializable{
	private static final long serialVersionUID = -8070910094092685218L;
	
	private List<SField> fields = new ArrayList<SField>(4);
	private String tableName;//对应于表名
	
	public SRecord(){}
	
	public SRecord(List<SField> fields){
		this.fields = fields;
	}
	
	public SRecord(String tableName){
		this.tableName = tableName;
	}

	public SRecord(List<SField> fields, String tableName) {
		super();
		this.fields = fields;
		this.tableName = tableName;
	}

	public List<SField> getFields() {
		return fields;
	}

	public void setFields(List<SField> fields) {
		this.fields = fields;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	
	public boolean addField(SField field){
		return fields.add(field);
	}
	
	public SField getFieldByName(String name){
		if(name == null) return null;
		for(SField field:fields){
			if(field.getName().equalsIgnoreCase(name)) return field;
		}
		return null;
	}
	
	public String getFieldValueByName(String name){
		return getFieldValueByName(name, "");
	}
	
	public String getFieldValueByName(String name,String dv){
		SField field = getFieldByName(name);
		if(field == null){
			return dv;
		}else{
			Object o = field.getValue();
			if(o == null) return dv;
			return o.toString();
		}
	}
	

}
