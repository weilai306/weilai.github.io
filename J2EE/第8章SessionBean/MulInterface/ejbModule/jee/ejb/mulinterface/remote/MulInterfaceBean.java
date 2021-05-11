package jee.ejb.mulinterface.remote;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless

public class MulInterfaceBean implements HelloRemote, HelloLocal,MulBy2Remote {

	int value=1;
	@EJB jee.ejb.mulinterface.remote.HelloLocal hello;
    public MulInterfaceBean() {
        // TODO Auto-generated constructor stub
    }
    

    public String sayHelloFromLocal(String name){

        return " Hello " + name + " from local!";

    }
    public String sayHelloFromRemote(String name){

    	String result=null;
    	result=hello.sayHelloFromLocal(name);
    	return result;    			

    }
   
    public int mul(){
    	value=value*2;
    	return value;
    	
    }

}
