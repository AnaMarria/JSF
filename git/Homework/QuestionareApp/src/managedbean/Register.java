package managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@ManagedBean(name = "register")
@RequestScoped
public class Register {

	private long userID;
	private String name;
	private String score;
	private String subject;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Add student information in db regarding an exam
	 * @return
	 */
	public String add() {
		int i = 0;

		if (userID != 0) {
			PreparedStatement ps = null;
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfproject", "root", "MysqlAna05");
				String sql = "INSERT INTO student_results(userId, name, score, subject) VALUES(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setLong(1, userID);
				ps.setString(2, name);
				ps.setString(3, score);
				ps.setString(4, subject);

				i = ps.executeUpdate();
				System.out.println("Data Added Successfully");
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					con.close();
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (i > 0) {
				return "output";
			} else {
				return "invalid";
			}
		} else {
			return "invalid";
		}
	}
	
	/**
	 * Go to the registration page, as a student
	 * @return
	 */
	public static String saveScore() {
		return "register";
	}

}
