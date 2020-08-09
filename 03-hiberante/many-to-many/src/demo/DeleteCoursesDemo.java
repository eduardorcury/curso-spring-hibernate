package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
											
		// criando sess�o
		Session session = factory.getCurrentSession();
		
		try {
			
			// come�ando transa��o
			session.beginTransaction();
			
			// retornando Course do banco
			Integer id = 10;
			Course course = session.get(Course.class, id);
			
			// deletando Course
			System.out.println("Deletando curso: " + course);
			session.delete(course);
			
			// commitando transa��o
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
