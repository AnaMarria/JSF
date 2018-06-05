package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";

		System.out.println("MySQL JDBC connection test");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySql JDBC driver?");
			e.printStackTrace();
		}

		System.out.println("MySql JDBC Driver registered");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfproject", "root", "MysqlAna05");
		} catch (SQLException e) {
			System.out.println("Connection failed! check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection");
		}

		return connection;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}