package jee.ejb.mulinterface.remote;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {

public String sayHelloFromRemote(String name);

}

