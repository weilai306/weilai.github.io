package jee.ejb.testjpa.ejb;

import javax.ejb.Remote;

@Remote
public interface JpaEjbRemote {
	public void getJpa();
}
