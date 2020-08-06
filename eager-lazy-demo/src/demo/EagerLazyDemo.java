package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
											
		// criando sess�o
		Session session = factory.getCurrentSession();
		
		try {
			
			// come�ando transa��o
			session.beginTransaction();
			
			// retornar Instructor
			Integer id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			System.out.println("luv2code: Cursos: " + tempInstructor.getCourses());
				
			// commitando transa��o
			session.getTransaction().commit();
			
			System.out.println("\nFechando sess�o\n");
			session.close();
			// retornar erro por causa do LAZY fetchtype
			System.out.println("luv2code: Cursos: " + tempInstructor.getCourses());
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
