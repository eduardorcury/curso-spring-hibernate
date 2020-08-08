package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class AddCoursesDemo {

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
											
		// criando sessão
		Session session = factory.getCurrentSession();
		
		try {
			
			// começando transação
			session.beginTransaction();
			
			// retornando Student do banco
			Integer id = 3;
			Student student = session.get(Student.class, id);
			System.out.println("\nEstudante: " + student);
			System.out.println("Cursos do estudante: " + student.getCourses());
			
			// criando cursos
			Course course1 = new Course("Desenvolvimento de jogos com Unity");
			Course course2 = new Course("IA com Python");
			Course course3 = new Course("Curso de aberturas no Xadrez");
			
			// adicionando student aos cursos
			student.addCourse(course1);
			student.addCourse(course2);
			student.addCourse(course3);
			
			// salvando cursos
			System.out.println("\nSalvando cursos...");
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
