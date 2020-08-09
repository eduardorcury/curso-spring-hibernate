package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class DeleteInstructorDetailsDemo {

	public static void main(String[] args) {

		// criando session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			// começando transação
			session.beginTransaction();
			
			Integer id = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("InstructorDetail: " + instructorDetail);
			
			System.out.println("Objeto associado: " + instructorDetail.getInstructor());
			
			System.out.println("Deletando objeto...");
			
			// quebrando a ligação com outro objeto
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			
			// commitando transação
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	
	}

}
