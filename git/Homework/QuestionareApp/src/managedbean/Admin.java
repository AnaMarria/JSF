package managedbean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Admin {
	ArrayList records;

	public ArrayList getRecords() {
		return records;
	}

	public void setRecords(ArrayList records) {
		this.records = records;
	}
	
	/**
	 * Get all exams results
	 * @return
	 */
	public String getAllStudentExams() {
		records = Records.getResultsForAdmin();
		return "adminHistoric";
	}
	
	/**
	 * 
	 * Get user by id and call the delete method 
	 * @param studentId
	 * @return
	 */
	public String deleteStudentRecord(int studentId) {
		System.out.println("id ul este: " + studentId);
		return Records.deleteStudentRecordInDB(studentId);
	}
}
