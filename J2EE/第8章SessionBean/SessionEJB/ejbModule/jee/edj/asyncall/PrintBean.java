package jee.edj.asyncall;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;


/**
 * Session Bean implementation class PrintBean
 */
@Stateless
@LocalBean
public class PrintBean {


    @Asynchronous
    public void printAndForget() {
        // Print
        System.out.println("*** printAndForget ***");
    }
 
    @Asynchronous
    public Future<String> printAndCheckLater() {
        // Print
        System.out.println("*** printAndCheckLater ***");
        return new AsyncResult<String>("OK");
    }

}
