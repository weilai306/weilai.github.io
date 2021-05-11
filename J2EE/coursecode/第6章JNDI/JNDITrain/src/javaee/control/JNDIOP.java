package javaee.control;

import java.sql.Connection;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Named("op")
@RequestScoped
public class JNDIOP {
	
	Context ctx ;
	private String msg = "";
	private String name = "";
	private String lookup_str = "";	
	private String bind_name = "";
	private String bind_value = "";	
	private String find_name = "";
	public String getFind_name() {
		return find_name;
	}

	public void setFind_name(String find_name) {
		this.find_name = find_name;
	}

	private String find_value = "";
	
	public String getBind_name() {
		return bind_name;
	}

	public void setBind_name(String bind_name) {
		this.bind_name = bind_name;
	}

	public String getBind_value() {
		return bind_value;
	}

	public void setBind_value(String bind_value) {
		this.bind_value = bind_value;
	}

	public String getFind_value() {
		return find_value;
	}

	public void setFind_value(String find_value) {
		this.find_value = find_value;
	}

	public String getLookup_str() {
		return lookup_str;
	}

	public void setLookup_str(String lookup_str) {
		this.lookup_str = lookup_str;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String lookup(){

		try {
			if (ctx == null) {
				ctx = new InitialContext();
			}
			/*
			DataSource ds = (DataSource) ctx
					.lookup("java:jboss/datasources/MySqlDS");
			Connection conn = ds.getConnection();
			if(conn != null){
				msg = "成功！成功从数据源'java:jboss/datasources/MySqlDS'获得数据库连接";
			}else
			{
				msg = "失败！从数据源'java:jboss/datasources/MySqlDS'获得数据库连接失败'";
			}
			*/
			find_name = "";
			find_value = "";
			String rst = (String)ctx.lookup(bind_name);
			find_name = bind_name;
			find_value = rst;
		} catch (NamingException e) {
			msg = "失败！JNDI异常";
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			msg = "失败！获取数据库连接异常";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String bind(){

		try {
			if (ctx == null) {
				ctx = new InitialContext();
			}
			ctx.bind(bind_name, bind_value);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}	
	
	public String unbind(){
		try {
			if (ctx == null) {
				ctx = new InitialContext();
			}
			ctx.unbind(bind_name);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	public String rebind(){
		try {
			if (ctx == null) {
				ctx = new InitialContext();
			}
			ctx.rebind(bind_name, bind_value);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}		
}
