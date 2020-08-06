package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;

public class GetReviewsDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			// começando transação
			session.beginTransaction();
			
			Integer id = 10;
			Course course = session.get(Course.class, id);
			
			System.out.println("Course: " + course);
			System.out.println("Reviews: " + course.getReviews());
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
