package mulInterfaceClient;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import jee.ejb.mulinterface.remote.*;

public class MulInterfaceClient {
	public static void main(String[] args)  throws Exception{
	 String  result="";
	 try{
			   Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	           jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	           Context context = new InitialContext(jndiProperties);
	                
	                 final String appName = "";
	                 final String moduleName = "MulInterface";
	                 final String distinctName = "";
	                 
	                System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/CallerBean!ejbdemo.stateless.local.CallerRemote");
	             
		  
	                HelloRemote helloremote=(HelloRemote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulInterfaceBean!jee.ejb.mulinterface.remote.HelloRemote");
                    System.out.println(helloremote.sayHelloFromRemote("jlu"));
                    MulBy2Remote mulBy2remote=(MulBy2Remote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulInterfaceBean!jee.ejb.mulinterface.remote.MulBy2Remote");
                    int value=mulBy2remote.mul();
                    System.out.println(String.valueOf(value));
                    
         }
		   catch(Exception e){ e.printStackTrace(); }
		
	}

}
