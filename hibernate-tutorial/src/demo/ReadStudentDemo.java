package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Eduardo", "Cury", "eduardo@gmail.com");
			
			// come�ando transa��o
			session.beginTransaction();
			
			// salvando objeto
			System.out.println("Salvando objeto...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commitando transa��o
			session.getTransaction().commit();
			
			System.out.println("Estudando java. Id gerado: " + tempStudent.getId());
			
			// criando nova sess�o e iniciando transa��o
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// query ao banco de dados com Id
			System.out.println("\nPegando estudante com id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Estudante recuperado: " + myStudent);
			
			// commitando transa��o
			session.getTransaction().commit();
			
			System.out.println("Pronto!");
			
		} finally {
			session.close();
		}
	
	}

}
