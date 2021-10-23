package shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	private static final String host = "jdbc:mysql://localhost:3306/garagemautomotiva";
	private static final String username = "root";
	private static final String password = "admin";
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(host, username, password);
			if(con != null)
				return con;
		}catch(SQLException error) {
			System.out.println("Erro de conexao: " + error.getMessage());
			return null;
		}
		
		return null;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
