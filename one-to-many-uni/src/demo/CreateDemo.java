package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class CreateDemo {

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
			
			// criando os objetos
			Instructor tempInstructor = new Instructor("Eduardo", "Ribeiro", "eduardo@gmail.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail
							("http://www.youtube.com/canal", 
							"Programar");
			
			// associando os objetos
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// começando transação
			session.beginTransaction();
			
			// salvando objeto
			System.out.println("Salvando instrutor e detail...");
			session.save(tempInstructor);
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	
	}

}
