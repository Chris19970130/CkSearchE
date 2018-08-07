package com.chris.CkSearchE.input.data.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public interface IFieldType {
	public Object getValue(ResultSet rs,String colLabel) throws SQLException;

	public class UnknownType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return null;
		}
	}
	
	public class BooleanType implements IFieldType{
		public BooleanType() {}
		
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return rs.getBoolean(colLabel);
		}
	}
	
	public class IntegerType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return rs.getInt(colLabel);
		}
	}
	
	public class LongType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return rs.getLong(colLabel);
		}
	}
	
	public class FloatType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return rs.getFloat(colLabel);
		}
	}
	
	public class DoubleType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return rs.getDouble(colLabel);
		}
	}
	
	public class StringType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			return rs.getString(colLabel);
		}
	}
	
	public class DateType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			Timestamp d = rs.getTimestamp(colLabel);
			if(d != null) return new Date(d.getTime());
			else return null;
		}
	}
	

	public class TimeType implements IFieldType{
		@Override
		public Object getValue(ResultSet rs, String colLabel) throws SQLException{
			Timestamp d = rs.getTimestamp(colLabel);
			if(d != null) return new java.sql.Date(d.getTime());
			else return null;
		}
	}
}
