package jee.ejb.testjpa.ejb;

import javax.ejb.Local;

@Local
public interface JpaEjbLocal {
	public void getJpa();
}
