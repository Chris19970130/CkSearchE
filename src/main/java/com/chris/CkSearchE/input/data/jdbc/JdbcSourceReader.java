package com.chris.CkSearchE.input.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chris.CkSearchE.config.EToolConfig;
import com.chris.CkSearchE.config.TableConfig;
import com.chris.CkSearchE.config.sourceFactory.JdbcConfig;
import com.chris.CkSearchE.input.data.entity.SRecord;
import com.chris.CkSearchE.input.data.entity.SRecordFactory;


/**
 * 2018-08-06
 * oracle数据读取器
 * @author 徐晨坤
 *
 */
public class JdbcSourceReader {
	private EToolConfig config;
	private Connection connection;
	private int lineNo;//读取行数
	private String tableName;//读取表名
	private String term;//抽取表的条件
	
	private SRecordFactory recordFactory;
	
	private Statement s;
	private ResultSet rs;
	
	public JdbcSourceReader(EToolConfig config) {
		this.config = config;
		this.init();
	}
	
	private void init(){
		try {
			this.connection = createConnection();
			this.tableName = ((TableConfig)this.config.getTableConfig()).getName();
			this.term = ((TableConfig)this.config.getTableConfig()).getTerm();
			this.lineNo = 0;
			
			this.recordFactory = new SRecordFactory();
			
			this.s = this.connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			this.s.setFetchSize(256);
			this.rs = s.executeQuery(getSql());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() throws SQLException{
		oracle.jdbc.driver.OracleDriver.class.getName();
		String url = ((JdbcConfig)this.config.getSourceConfig()).getUrl();
		String user = ((JdbcConfig)this.config.getSourceConfig()).getUser();
		String pass = ((JdbcConfig)this.config.getSourceConfig()).getPass();
		return DriverManager.getConnection(url,user,pass);
	}

	private String getSql(){
		String sql = "";
		if(this.term == "" || this.term.isEmpty()){
			sql = String.format("SELECT * FROM %s", this.tableName);
		}else {
			sql = String.format("SELECT * FROM %s where (%s)", this.tableName,this.term);
		}
		return sql;
	}
	
	public SRecord readRecord(){
		while(true){
			return _readNext();
		}
	}
	
	private SRecord _readNext(){
		try {
			if(this.rs.next()){
				this.lineNo ++;
				return recordFactory.createRecord(rs, this.tableName);
			}
		} catch (SQLException e) {
			this.lineNo --;
			e.printStackTrace();
		}
		return null;
	}
	
	public int getLineNo(){
		return this.lineNo;
	}

}
