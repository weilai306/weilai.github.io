package javaee.ejb.singleton.concurrency;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SimulationBeanManaged {
    public enum State {PAUSED, RUNNING, TERMINATED};
    private State state;

    public State getState() {
        return state;
    }

    public synchronized void setState1(State state) {
        this.state = state;
    }
    
    
    public void setState2(State state) {
    	synchronized (this) {
    	this.state = state;
    	}
    	}

}
