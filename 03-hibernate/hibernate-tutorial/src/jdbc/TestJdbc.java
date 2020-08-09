package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";

		try {
			System.out.println("Conectando ao banco de dados");
			Connection con = 
					DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Conexão bem-sucedida");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
