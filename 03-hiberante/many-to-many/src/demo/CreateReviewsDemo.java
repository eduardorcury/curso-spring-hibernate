package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;

public class CreateReviewsDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
											
		// criando sess�o
		Session session = factory.getCurrentSession();
		
		try {
			
			// come�ando transa��o
			session.beginTransaction();
			
			// criando um course
			Course course = new Course("Curso HTML/CSS/Javascript");
			
			// adicionando reviews
			course.addReview(new Review("�timo curso!"));
			course.addReview(new Review("Bom, bonito e barato"));
			course.addReview(new Review("Curso meh..."));
			
			// salvando curso (cascade ALL)
			System.out.println("Salvando curso e reviews...");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(course);
			
			// commitando transa��o
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
