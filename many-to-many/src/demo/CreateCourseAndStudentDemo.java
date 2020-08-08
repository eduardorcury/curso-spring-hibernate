package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			// criando um course
			Course course = new Course("Curso HTML/CSS/Javascript");
		
			// salvando curso (cascade ALL)
			System.out.println("Salvando curso...");
			session.save(course);
			System.out.println(course);
			System.out.println("Curso salvo: " + course);
			
			// criando Students
			Student student1 = new Student("Eduardo", "Ribeiro", "eduardo@gmail.com");
			Student student2 = new Student("Maria", "Silva", "maria@gmail.com");
			
			// adicionando Students ao curso
			course.addStudent(student1);
			course.addStudent(student2);
			
			// salvando Students
			System.out.println("Salvando estudantes...");
			session.save(student1);
			session.save(student2);
			System.out.println("Estudantes salvos: " + course.getStudents());
			
			// commitando transação
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	
	}

}
