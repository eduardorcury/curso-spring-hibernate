package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			// recuperat objeto pelo id
			Integer id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("Objeto recuperado: " + tempInstructor);
			
			// deletar objeto
			if (tempInstructor != null) {
				System.out.println("Deletando objeto...");
				session.delete(tempInstructor);
			}
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	
	}

}
