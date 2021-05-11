package jluee.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jluee.entity.User;



public class UserDao extends BaseDao{	
	
	String datesource="java:jboss/datasources/MySqlDS";
	public void registerUser(User user) throws Exception {
		if(user != null){
			String sql = "insert into tuser values(?,?,?,?,?)";
			this.openconnection(datesource);			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPwd());				
			ps.setString(3, user.getRole());
			ps.setString(4, user.getEmail());
			ps.setDouble(5, 1000D);
			ps.executeUpdate();				
		}
	}
	
	public User login (String uname,String pwd)throws Exception{
		User user=null;
		String sql="select userName,passWord,role from j2ee WHERE userName='" + uname + "' and passWord='" + pwd + "'";
		//this.openconnection();	
		this.openconnection(datesource);		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs!=null){
			while(rs.next()){
				user=new User();
				user.setUname(rs.getString("userName"));   
				user.setPwd(rs.getString("passWord"));
				user.setRole(rs.getString("role"));
			}
		}				
		
		return user;
	}		

}
