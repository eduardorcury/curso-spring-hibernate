package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			// começando transação
			session.beginTransaction();
			
			// pegando curso
			Integer id = 10;
			Course course = session.get(Course.class, id);
			
			// deletando curso
			System.out.println("Deletando curso: " + course);
			session.delete(course);
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
