package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
											
		// criando sess�o
		Session session = factory.getCurrentSession();
		
		try {
			// criando tr�s objetos
			System.out.println("Criando objetos...");
			Student tempStudent1 = new Student("Eduardo", "Ribeiro", "eduardo@gmail.com");
			Student tempStudent2 = new Student("J�ao", "Silva", "joao@gmail.com");
			Student tempStudent3 = new Student("Maria", "Costa", "maria@gmail.com");
			
			// come�ando transa��o
			session.beginTransaction();
			
			// salvando objeto
			System.out.println("Salvando objetos...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commitando transa��o
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}

	}

}
