package SingletonClient;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException; 
import jee.ejb.singleton.remote.*;

public class SimpleSingletonClient {

 	 public static void main(String[] args) {
	 Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
     jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
     try {
         Context context = new InitialContext(jndiProperties);
        
         final String appName = "";
         final String moduleName = "SessionEJB";
         final String distinctName = "";
         System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/SimpleSingletonBean!ejbdemo.singleton.remote.SimpleSingletonRemote");
         Object obj;
        
         SimpleSingletonBeanRemote single01 =(SimpleSingletonBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/SimpleSingletonBean!jee.ejb.singleton.remote.SimpleSingletonBeanRemote");
         SimpleSingletonBeanRemote single02=(SimpleSingletonBeanRemote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/SimpleSingletonBean!jee.ejb.singleton.remote.SimpleSingletonBeanRemote");
       
         int value1=single01.getValue();
         int value2=single02.getValue();
         System.out.println("Singleton01 初始值：   "+ String.valueOf(value1));       
         System.out.println("Singleton02初始值：   "+ String.valueOf(value2));
         single01.change01();
         value1=single01.getValue();
         value2=single02.getValue();
         System.out.println("Singleton01值：   "+ String.valueOf(value1));
         System.out.println("Singleton02值：   "+ String.valueOf(value2));
         single02.change01();
         value1=single01.getValue();
         value2=single02.getValue();
         System.out.println("Singleton01值：   "+ String.valueOf(value1));
         System.out.println("Singleton02值：   "+ String.valueOf(value2));

     } catch (NamingException e) {
         e.printStackTrace();}
     }


}
