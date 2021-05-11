package jee.ejb.mulinterface.remote;

import javax.ejb.Local;

@Local
public interface HelloLocal {
	public String sayHelloFromLocal(String name);

}
