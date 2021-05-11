	package jluee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jluee.util.Log;


public class BaseDao {

	protected Connection conn = null;
	protected static final String  dbJndi = "java:jboss/datasources/MySqlDS";  
	
	/*
	 * 获取数据库连接
	 */
	protected void openconnection() throws ClassNotFoundException,SQLException{		
		try {
			if( conn == null || conn.isClosed() ){
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/testdb"; 
			    String user = "root"; 
				String password = "weilai"; 
				conn = DriverManager.getConnection(url,user,password);
			}			
		} catch (ClassNotFoundException e) {			
			Log.logger.error(e.toString());
		    throw e;
		} catch (SQLException e) {	
			Log.logger.error(e.toString());
			throw e;
		}
	}	
	
	//例如：DataSource ds = (DataSource)ctx.lookup( "java:comp/env/jdbc/OracleJspDemoJndi" ) ;
	protected void openconnection(String strJNDIName) throws Exception{
		try {
            InitialContext context = new InitialContext();
            strJNDIName.trim(); 						//很重要，从配置文件中读到的数据常有不可见字符
            DataSource ds = (DataSource)context.lookup(strJNDIName) ;
    		conn = ds.getConnection();    		
        } 
		catch (NamingException e) {
				throw e;
        } catch (Exception e) {
        	throw e;        	   	
        }
	}
	
	
	public void beginTransaction() throws Exception{
	
		this.openconnection();		
		conn.setAutoCommit(false);		
	}
	
	public void rollback() throws Exception{
		
		if(conn != null){			
				conn.rollback();			
		}		
	}
	
	public void commit() throws Exception{
		if(conn != null){			
			conn.commit();				
		}	
	}

	/*
	 * 关闭资源
	 */
	public void closeResource() throws Exception{		
		if(conn != null){
			conn.close();
		}			
		
	}
	
	//根据翻页参数，获得需要的结果集  iStart从1开始>=iStart; <iEnd
		public  ResultSet executeQuery(String strSql,int iStart,int iEnd) throws Exception{	
			ResultSet rs = null;				
			Statement st = conn.createStatement();	
			if(st != null){				
				String strNew = "select * from  (select rownum numrow,tb.* from ( " + strSql + " ) tb ) where numrow >=" + iStart + " and numrow<" + iEnd ;					
				rs = st.executeQuery(strNew);
			}			
			
			return rs;
		}   
		
	public  int getRecCount(String strSql) throws Exception{
		int iRec = 0;
		
		//mysql 中必须加别名w
		String strExe = "SELECT count(*) FROM (" + strSql + ") w";	
		Object obj = executeScalar(strExe);
		if(obj != null){
			iRec = Integer.parseInt(obj.toString());		
		}
		
		return iRec;
	}
	
	//返回查询结果的第一行第一列的值(---如果没有查询结果，则返回null)
		public  Object executeScalar(String strSql) throws Exception{
			ResultSet rs;			
			Object obj;
			
			obj = null;
			rs = null;			
				
			Statement st = conn.createStatement();						
			rs = st.executeQuery(strSql);
			if( rs != null ){
				while( rs.next()){
					if(rs.isFirst()){
						obj = rs.getObject(1);  //columnIndex - 第一个列是 1
						break;
					}						
				}
				rs.close();
			}							
			
			return obj;
		}    
	
}
