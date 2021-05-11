package jluee.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

public class RemoteClient {

    public static void main(String[] args) throws Exception {
    	Context ctx = null;
    	Properties prop = new Properties();
    	//服务器的命名和目录管理地址//remote://
    	//jnp://localhost:1099 remote://localhost:4447
    	prop.put(Context.PROVIDER_URL, "remote://localhost:4447");			
    	//初始化上下文环境工厂
    	prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
    	//用户验证
    	prop.put(Context.SECURITY_PRINCIPAL, 
    			System.getProperty("username","testJNDI"));
    		prop.put(Context.SECURITY_CREDENTIALS, 
    			System.getProperty("password","weilai"));
    		String str="";	
    		prop.put("jboss.naming.client.ejb.context", true);
    		
    	try {
			ctx = new InitialContext(prop);
			//java:jboss/exported/Myschool
			String str1 = (String)ctx.lookup("Myschool");
			System.out.println(str1);		
		} catch (javax.naming.NameNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("name not found");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
    	System.out.println(str);		
    }
}
