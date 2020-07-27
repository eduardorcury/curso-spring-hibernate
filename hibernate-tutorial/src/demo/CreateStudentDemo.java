package demo;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
											
		// criando sess�o
		Session session = factory.getCurrentSession();
		
		try {
			// criando objeto
			System.out.println("Criando objeto...");
			Student tempStudent = new Student("Eduardo", "Ribeiro", "eduardo@gmail.com");
			
			// come�ando transa��o
			session.beginTransaction();
			
			// salvando objeto
			System.out.println("Salvando objeto...");
			session.save(tempStudent);
			
			// commitando transa��o
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	
	}

}
