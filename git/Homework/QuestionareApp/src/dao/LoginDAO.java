package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataConnect;

public class LoginDAO {

	/**
	 * Validate user credentials
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean validate(String username, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select username, password, userrole from users where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}

	/**
	 * Get user role from database
	 * 
	 * @param username
	 * @return
	 */
	public static String getUserRole(String username) {

		Connection con = null;
		PreparedStatement ps = null;
		String userrole;

		try {
			String queryString = "SELECT * FROM users WHERE username = '" + username + "' ";
			con = DataConnect.getConnection();
			ps = con.prepareStatement(queryString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				System.out.println("Username:  " + rs.getString("username") + ", Password:  " + rs.getString("password")
						+ ", Address " + rs.getString("email") + ", User role " + rs.getString("userrole"));

				userrole = rs.getString("userrole");
				return userrole;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return "Error";
	}

}