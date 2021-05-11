package jee.ejb.stateless.remote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@LocalBean
public class HelloBean implements HelloBeanRemote {
    public HelloBean() {
        // TODO Auto-generated constructor stub
    }
    public String sayHello(String name){
        return "Hello " + name + "!";
    }
}
