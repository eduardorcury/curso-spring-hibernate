package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// criando nova sessão e iniciando transação
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// query ao banco de dados com Id
			System.out.println("\nPegando estudante com id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// Update no objeto
			System.out.println("Atualizando estudante...");
			myStudent.setFirstName("Scooby");
			
			// commitando transação
			session.getTransaction().commit();
			
			// atualizando email para todos os estudantes
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Atualizando emails...");
			
			session.createQuery("update Student set email='email@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Pronto!");
			
		} finally {
			session.close();
		}
	
	}

}
