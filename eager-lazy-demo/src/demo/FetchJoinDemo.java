package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			// query com HQL
			Integer id = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId",
							Instructor.class);
			
			query.setParameter("theInstructorId", id);
			
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("luv2code: Instructor: " + tempInstructor);
				
			// commitando transa��o
			session.getTransaction().commit();
			
			System.out.println("\nFechando sess�o\n");
			session.close();

			System.out.println("luv2code: Cursos: " + tempInstructor.getCourses());
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
