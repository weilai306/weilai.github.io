package javaee.jpa.one2one.bidirection;
import javax.persistence.*;
import java.util.*;

public class Client {


 public static void main(String[] args) throws Exception 
  {   	  
	   EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("JPARelation",null);
	   EntityManager  manager = factory.createEntityManager();
      try 
      {          createStudent(manager);
				 showAll(manager);
				 queryFromMaintained(manager);
				  
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }
   public static void createStudent(EntityManager manager) 
   {
			Student p=new Student();
                
			p.setName("wangwu6");
			p.setGender("male");
			p.setMajor("computer");
			Address ad=new Address ();
	        ad.setDetail("����ʡ������ǰ�����2699��");
	        ad.setProvince("����ʡ");
	        ad.setCity("������");
	        ad.setZip("130012");
            p.setAddress(ad);
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(p);
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
  
  public static void queryFromMaintained(EntityManager manager) {  
	     
	  EntityTransaction transaction = manager.getTransaction();
	  transaction.begin();
	  Address address = manager.find(Address.class, 14);  
	  Student student =address.getStudent();
	  transaction.commit();
	  System.out.println("id=  "+student.getId());
	  System.out.println("name=  "+student.getName());  
	  System.out.println("manjor=   "+student.getMajor()); 
	}  
}






