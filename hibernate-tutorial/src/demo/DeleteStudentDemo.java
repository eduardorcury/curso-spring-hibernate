package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 3;
			
			// criando nova sessão e iniciando transação
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// query ao banco de dados com Id
			System.out.println("\nPegando estudante com id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// deletando objeto
			System.out.println("Deletando estudante " + myStudent);
			session.delete(myStudent);
			
			// deletando objeto com Query
			System.out.println("Deletando estudante com id = 2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commitando transação
			session.getTransaction().commit();
			
			System.out.println("Pronto!");
			
		} finally {
			session.close();
		}
	
	}

}
