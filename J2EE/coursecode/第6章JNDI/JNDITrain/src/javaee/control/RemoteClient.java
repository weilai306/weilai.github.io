package javaee.control;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

public class RemoteClient {
	
    public static void main(String[] args) throws Exception {
    	Context ctx = null;
    	Properties prop = new Properties();
    	//��������������Ŀ¼�����ַ
    	prop.put(Context.PROVIDER_URL, "remote://localhost:4447");			
    	//��ʼ�������Ļ�������
    	prop.put(Context.INITIAL_CONTEXT_FACTORY, 
    			org.jboss.naming.remote.client.InitialContextFactory.class.getName());
    	//�û���֤
    	prop.put(Context.SECURITY_PRINCIPAL, 
    			System.getProperty("username","testJNDI"));
    		prop.put(Context.SECURITY_CREDENTIALS, 
    			System.getProperty("password","weilai"));
    		
    	try {
			ctx = new InitialContext(prop);

			//ctx.bind("MyName", "JACK");
			String str = (String)ctx.lookup("myschool");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
