package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// criar Cursos
			Course course1 = new Course("Docker e Kubernetes");
			Course course2 = new Course("Microsserviços com Java");
			
			// ligar cursos ao instrutor
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			
			// salvando cursos
			session.save(course1);
			session.save(course2);
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
