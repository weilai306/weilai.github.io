package javaee.jpa.one2many.oneway;
import javax.persistence.*;
import java.util.*;

public class Client {


 public static void main(String[] args) throws Exception 
  {   	  
     EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("one2many1",null);
       EntityManager manager = factory.createEntityManager();
      try 
      {         
    	         testsave1(manager);
    	         
				 showAll(manager);
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }
   public static void testsave1(EntityManager manager) 
   {
	   Student p=new Student ();
	   p.setName("赵二");
	   p.setGender("male");
	   p.setMajor("computer technology");
	   Teacher t=new Teacher();
	   t.setTeacherName("王一");
	   t.setAge(31);
	   t.setGender("male");
	   t.getStudents().add(p);
	   Student p2=new Student ();
	   p2.setName("张三");
	   p2.setGender("male");
	   p2.setMajor("computer Science");
	   t.getStudents().add(p2);
     EntityTransaction transaction = manager.getTransaction();
     transaction.begin();
      manager.persist(t);
      
      transaction.commit();
   }
   
  
  public static void showAll(EntityManager manager)
   {
   	     EntityTransaction transaction = manager.getTransaction();
   	     transaction.begin();
  	     Query q=manager.createQuery("from Student c");
         List results=q.getResultList();
        transaction.commit();
         Iterator it=results.iterator();
         while(it.hasNext())
        {
        	 Student p=(Student)it.next();
        	  System.out.print(p.getId()+"\t");
         	  System.out.print(p.getName()+"\t");
        		  System.out.println(p.getGender()+"\t");
         }
   }
}






