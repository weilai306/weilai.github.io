package statefulClient;

import javax.ejb.Remote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException; 
import java.util.Hashtable;
import jee.ejb.stateful.remote.MulBy2Remote;

 

public class StatefulBeanClient {

 

      	 public static void main(String[] args) {
    	        // TODO Auto-generated method stub
      		 Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
             jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
             try {
                 Context context = new InitialContext(jndiProperties);
                
                 final String appName = "";
                 final String moduleName = "SessionEJB";
                 final String distinctName = "";
                System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!jee.ejb.stateful.remote.MulBy2Remote?stateful");
//                生成第一个客户端
                
                 Object obj = context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!jee.ejb.stateful.remote.MulBy2Remote?stateful");
                
                 MulBy2Remote mulBy2R1 =(MulBy2Remote)obj;
//          生成第个客户端       
                 obj = context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!jee.ejb.stateful.remote.MulBy2Remote?stateful");
                 
                 MulBy2Remote mulBy2R2 =(MulBy2Remote)obj;
                 int j1=mulBy2R1.mul();
                 j1=mulBy2R1.mul();
                 System.out.println("the  value in Clinet 1:  "+j1);
                 int j2=mulBy2R2.mul();
                 System.out.println("the  value in Clinet 2:  "+j2);
                           
             } catch (NamingException e) {
                 e.printStackTrace();
             }
 
    	        
    	    }
 

}

 