package jee.ejb.singleton.remote;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class SimpleSingletonBean
 */
@Singleton
public class SimpleSingletonBean implements SimpleSingletonBeanRemote {
	 int i=0;
		public SimpleSingletonBean () {
	        // TODO Auto-generated constructor stub
	    }
	    public void change01(){
	    	if (i==0) 
	    		i=1;
	    	else 
	    		i=0;
	    	
	        	
	}
	public int getValue(){
	    return i;
	}


}
