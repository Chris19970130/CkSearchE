package com.chris.CkSearchE.input.data.entity;

import java.io.Serializable;

/**
 * 2018-08-06
 * 对应字段键-字段值，key-value的实体对象，多个SField可以组成一个SRecord（对应于表中的一条记录）
 * @author 徐晨坤
 *
 */
public class SField implements Serializable{
	private static final long serialVersionUID = -1455221385348884515L;
	
	protected String name;
	protected Object value;
	
	public SField(){}

	public SField(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	

}
