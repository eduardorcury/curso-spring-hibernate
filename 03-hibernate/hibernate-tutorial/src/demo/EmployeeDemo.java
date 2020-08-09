package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Employee;

public class EmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// Criando objetos
			Employee employee1 = new Employee("Jõao", "Silva", "IBM");
			Employee employee2 = new Employee("Maria", "Costa", "Google");
			Employee employee3 = new Employee("Eduardo", "Ribeiro", "Zup");
			
			// Salvando objetos
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			
			// Retornando objeto com id=2
			int id = 2;
			Employee employee = session.get(Employee.class, id);
			System.out.println("Employee com id=2: " + employee);
			
			// Retornando objetos com company=zup
			List<Employee> employees = session.createQuery("from Employee s where s.company='Zup'").getResultList();
			
			for (Employee myEmployee : employees) {
				System.out.println(myEmployee);
			}
			
			session.getTransaction().commit();
			
			
			
		} finally {
			session.close();
		}

	}

}
