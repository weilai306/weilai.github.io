package ejbdemo.nointerface;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
public class NoInterfaceHelloBean {

    public NoInterfaceHelloBean() {
    }
    
    public String sayHello(String s) {
        String message="hello: "+s;    
        return message;
             }

}
