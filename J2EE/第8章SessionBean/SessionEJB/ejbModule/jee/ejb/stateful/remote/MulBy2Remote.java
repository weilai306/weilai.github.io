package jee.ejb.stateful.remote;

import javax.ejb.Remote;

@Remote
public interface MulBy2Remote {
	public int mul();

}

