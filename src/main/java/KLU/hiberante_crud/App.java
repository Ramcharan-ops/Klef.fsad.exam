package KLU.hibernate_crud;

import javax.naming.ConfigurationException;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction; 
import org.hibernate.cfg.Configuration;

/** 
 * Hello world!
  */ 
public class App 
{ 
	public static void main(String[] args)
	{
		System.out.println("Hello World!");
		
 ConfigurationException config = new ConfigurationException();
 config.configure("hibernate.cfg.xml");
 
 SessionFactory factory = config.buildSessionFactory();
 Session session = factory.openSession();
 Transaction tx = session.beginTransaction();
 
//Insert 
 Employee e =new Employee();
 e.setId(9); 
 e.setFn("S"); 
 e.setLn("Krishna");
 e.setBranch("CSE");
 session.save(e);
 tx.commit();
 System.out.println("Record Inserted Successfully");
 
 //Retrieve
 
 Employee e1 = session.find(Employee.class,1);
 System.out.println("Record retrieved Successfully"+ " " +e1.getFn());

 //update
 
 Employee e2 = session.find(Employee.class,3); 
 e2.setLn("Lekhana");
 e2.setBranch("ECE");
 session.update(e2);
 Transaction tnx = session.beginTransaction();
 tnx.commit();
 System.out.println("Record Updated Successfully");
 
//delete
 
 Employee e3 = session.find(Employee.class,8);
 session.delete(e3);
 Transaction trnx = session.beginTransaction();
 trnx.commit();
 System.out.println("Record Deleted Successfully");
 session.close();
 }
	}
 