package com.chris.CkSearchE.input.data.entity;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.TreeMap;

public class SRecordFactory {
	public final static Map<Integer,IFieldType> TYPEMAP = new TreeMap<Integer,IFieldType>();
	static{
		TYPEMAP.put(Types.BOOLEAN,new IFieldType.BooleanType());
		TYPEMAP.put(Types.NUMERIC,new IFieldType.DoubleType());
		TYPEMAP.put(Types.INTEGER,new IFieldType.IntegerType());
		TYPEMAP.put(Types.BIGINT,new IFieldType.LongType());
		TYPEMAP.put(Types.FLOAT,new IFieldType.FloatType());
		TYPEMAP.put(Types.DOUBLE,new IFieldType.DoubleType());
		TYPEMAP.put(Types.VARCHAR,new IFieldType.StringType());
		TYPEMAP.put(Types.NVARCHAR,new IFieldType.StringType());
		TYPEMAP.put(Types.DATE,new IFieldType.DateType());
		TYPEMAP.put(Types.TIME,new IFieldType.TimeType());
	}
	
	public SRecord createRecord(ResultSet rs,String tableName) throws SQLException{
		ResultSetMetaData metaData = rs.getMetaData();
		SRecord sRecord = new SRecord(tableName);
		for(int i=1;i<metaData.getColumnCount()+1;i++){
			String fieldName = metaData.getColumnLabel(i);
			int fieldType = metaData.getColumnType(i);
			Object value = TYPEMAP.get(fieldType).getValue(rs, fieldName);
			sRecord.addField(new SField(fieldName, value));
		}
		
		return sRecord;
	}

}
