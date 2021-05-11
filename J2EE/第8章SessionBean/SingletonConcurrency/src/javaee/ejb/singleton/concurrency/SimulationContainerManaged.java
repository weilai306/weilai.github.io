package javaee.ejb.singleton.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;

@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SimulationContainerManaged {
    public enum State {PAUSED, RUNNING, TERMINATED};
    private State state;

    @Lock(LockType.READ)
    @AccessTimeout(20000)
    public State getState() {
        return state;
    }

    @Lock(LockType.WRITE)
    @AccessTimeout(20000)
    public void setState(State state) {
        this.state = state;
        try{
        CountDownLatch latch = new CountDownLatch(1);
		latch.await(10, TimeUnit.SECONDS);
        }
        catch(Exception e){
        	System.out.println("Ð´Ëø³öÏÖ´íÎó");
        }
    }


}
