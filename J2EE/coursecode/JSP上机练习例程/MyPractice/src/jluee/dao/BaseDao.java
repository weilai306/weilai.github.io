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
	 * ��ȡ���ݿ�����
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
	
	//���磺DataSource ds = (DataSource)ctx.lookup( "java:comp/env/jdbc/OracleJspDemoJndi" ) ;
	protected void openconnection(String strJNDIName) throws Exception{
		try {
            InitialContext context = new InitialContext();
            strJNDIName.trim(); 						//����Ҫ���������ļ��ж��������ݳ��в��ɼ��ַ�
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
	 * �ر���Դ
	 */
	public void closeResource() throws Exception{		
		if(conn != null){
			conn.close();
		}			
		
	}
	
	//���ݷ�ҳ�����������Ҫ�Ľ����  iStart��1��ʼ>=iStart; <iEnd
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
		
		//mysql �б���ӱ���w
		String strExe = "SELECT count(*) FROM (" + strSql + ") w";	
		Object obj = executeScalar(strExe);
		if(obj != null){
			iRec = Integer.parseInt(obj.toString());		
		}
		
		return iRec;
	}
	
	//���ز�ѯ����ĵ�һ�е�һ�е�ֵ(---���û�в�ѯ������򷵻�null)
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
						obj = rs.getObject(1);  //columnIndex - ��һ������ 1
						break;
					}						
				}
				rs.close();
			}							
			
			return obj;
		}    
	
}
