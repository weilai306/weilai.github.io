package jee.ejb.singleton.remote;

import javax.ejb.Remote;

@Remote
public interface SimpleSingletonBeanRemote {
	public void change01();
    public int getValue();


}
