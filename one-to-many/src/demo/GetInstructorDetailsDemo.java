package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class GetInstructorDetailsDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
											
		// criando sess�o
		Session session = factory.getCurrentSession();
		
		try {
			
			// come�ando transa��o
			session.beginTransaction();
			
			Integer id = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("InstructorDetail: " + instructorDetail);
			
			System.out.println("Objeto associado: " + instructorDetail.getInstructor());
			
			// commitando transa��o
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	
	}

}
