package hibernateEx;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
        SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
        		.buildSessionFactory();

		Session session = factory.openSession();
		
		Employee venci = new Employee("Venci", "Vencislavov", 300);
		
		session.save(venci);
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Employee venci = session.get(Employee.class, 1);
			venci.setSalary(500);
			session.update(venci);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		
		List res = session.createQuery("FROM Employee").getResultList();
		
		for (int i = 0; i < res.size(); i++) {
			
			Employee emp = (Employee)res.get(i);
			System.out.println(emp);
			
			
		}
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Employee venci = session.get(Employee.class, 1);
			venci.setSalary(500);
			session.delete(venci);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		
		session.close();
		
	}

}













