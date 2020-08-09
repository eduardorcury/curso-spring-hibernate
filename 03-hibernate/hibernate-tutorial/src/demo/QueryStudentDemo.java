package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			// começando transação
			session.beginTransaction();
			
			// query: retornar todos os objetos
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// mostrar objetos
			displayStudents(theStudents);
			
			// query: listar objeto com um determinado atributo
			theStudents = session.createQuery("from Student s where s.lastName='Ribeiro'").getResultList();
			
			System.out.println("\n\nEstudantes com último nome igual a Ribeiro:");
			displayStudents(theStudents);
			
			// query: lastName OU firstName
			theStudents = session
						.createQuery("from Student s where s.lastName='Ribeiro' OR s.firstName='Maria'")
						.getResultList();
			
			System.out.println("\n\nEstudantes com último nome igual a Ribeiro ou primeiro nome igual a Maria");
			displayStudents(theStudents);
			
			// query: retornar emails que terminam com uma String
			theStudents = session
						.createQuery("from Student s where s.email LIKE '%@gmail.com'")
						.getResultList();
			
			System.out.println("\n\nEstudantes com email terminado com @gmail.com");
			displayStudents(theStudents);
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student: theStudents) {
			System.out.println(student);
		}
	}

}
