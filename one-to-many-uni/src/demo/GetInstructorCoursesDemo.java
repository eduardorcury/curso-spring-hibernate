package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			
			// retornar Instructor
			Integer id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor: " + tempInstructor);
			System.out.println("Cursos: " + tempInstructor.getCourses());
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
