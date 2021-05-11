package jee.ejb.stateful.remote;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
@Stateful
public class MulBy2Bean implements MulBy2Remote {
  	int i=1;
    public MulBy2Bean() {
        // TODO Auto-generated constructor stub
    }
    public int mul(){
    	i=i*2;
    	return i;
    	
    }

}

