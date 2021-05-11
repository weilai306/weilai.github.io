package jee.ejb.testjpa.ejb;
import javax.persistence.*;
import java.util.*;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jluee.entity.Address;
import jluee.entity.Student;

/**
 * Session Bean implementation class JpaEjb
 */
@Stateless
@LocalBean
public class JpaEjb implements JpaEjbRemote, JpaEjbLocal {
	@PersistenceContext(unitName = "MyPractice")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public JpaEjb() {
        // TODO Auto-generated constructor stub
    }

	public void getJpa() {
		// TODO Auto-generated method stub
//		EntityManagerFactory factory =
//			       Persistence.createEntityManagerFactory("MyPractice",null);
//				   EntityManager  manager = factory.createEntityManager();
			      try 
			      {          createStudent(manager);
							 showAll(manager);
							 queryFromMaintained(manager);
			      } 
			      finally 
			      {
			         //manager.close();
//			         factory.close();
			      }
		
	}
    
	public static void createStudent(EntityManager manager) 
	   {
				Student p=new Student();
	                
				p.setName("wangwu6");
				p.setGender("male");
				p.setMajor("computer");
				Address ad=new Address ();
		        ad.setDetail("吉林省长春市前进大街2699号");
		        ad.setProvince("吉林省");
		        ad.setCity("长春市");
		        ad.setZip("130012");
	            p.setAddress(ad);       
	            manager.persist(p);
	   }
	  public static void showAll(EntityManager manager)
	   {	   	  	     
	  	     Query q=manager.createQuery("from Student c");
	         List results=q.getResultList();	        
	         Iterator it=results.iterator();
	         while(it.hasNext())
	        {
	        	  Student p=(Student)it.next();
	        	  System.out.print(p.getId()+"\t");
	         	  System.out.print(p.getName()+"\t");
	              System.out.println(p.getGender()+"\t");
	         }
	   }
	  
	  public static void queryFromMaintained(EntityManager manager) {  		   	 
		  Student student = manager.find(Student.class, 18);  
		  System.out.println("id=  "+student.getId());
		  System.out.println("name=  "+student.getName());  
		  System.out.println("manjor=   "+student.getMajor()); 
		}  
    

}
