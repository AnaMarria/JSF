package managedbean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DataConnect;


public class Records implements Serializable{
	private static final long serialVersionUID =  1L;
	static ArrayList records = new ArrayList();

	public ArrayList getRecords() {
		return records;
	}

	/**
	 * Get results for "Ana-Maria"
	 * @return
	 */
	public static ArrayList<Record> getResultsForStudent() {
		records.clear();
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			String queryString = "SELECT * FROM student_results WHERE name = '" + "Ana-Maria" + "' ";
			con = DataConnect.getConnection();
			ps = con.prepareStatement(queryString);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				System.out.println("Name:  " + rs.getString("name") + ", Score:  " + rs.getString("score")
						+ ", subject " + rs.getString("subject"));

				Record rcd = new Record(rs.getInt("userId"), rs.getString("name"), rs.getString("score"), rs.getString("subject"));
				records.add(rcd);

			}
		return records;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}		
	}

	/**
	 * Get all student results
	 * @return
	 */
	public static ArrayList<Record> getResultsForAdmin() {
		records.clear();
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			String queryString = "SELECT * FROM student_results";
			con = DataConnect.getConnection();
			ps = con.prepareStatement(queryString);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				System.out.println("Name:  " + rs.getString("name") + ", Score:  " + rs.getString("score")
						+ ", subject " + rs.getString("subject"));

				Record rcd = new Record(rs.getInt("userId"), rs.getString("name"), rs.getString("score"), rs.getString("subject"));
				records.add(rcd);
			}
		return records;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}		
	}
	
	/**
	 * Delete student record by id
	 * @param studentId
	 * @return
	 */
	public static String deleteStudentRecordInDB(int studentId){
		Connection con = null;
		PreparedStatement ps = null;
		
		System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
		try {
			String queryString = "delete from student_results where userId = "+studentId;
			con = DataConnect.getConnection();
			ps = con.prepareStatement(queryString);
			ps.executeUpdate();  
			con.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "admin";
	}
}
