package managedbean;

import java.awt.List;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import managedbean.Exam;
import xmlReader.AllQuestionTags;
import xmlReader.Subject;

@ManagedBean
@SessionScoped
public class Questionare implements Serializable {

	private static final long serialVersionUID = 1L;

	private static String answer;
	private double percentage;
	private String subject;
	ArrayList records;
	
	public String getSubject() {
		return subject;
	}

	public ArrayList getRecords() {
		return records;
	}

	public void setRecords(ArrayList records) {
		this.records = records;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	ArrayList myScores = new ArrayList();

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	/**
	 * Submit the questionnaire
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public String saveExam() throws ParserConfigurationException, SAXException, IOException {
		double correctsAnw = Exam.getCount();
		double questionsNumber = AllQuestionTags.getQuestionNumber();
		System.out.println("Numarul intrebarilor cu raspuns corect este: " + correctsAnw);
		System.out.println("Numarul intrebarilor din chestionar este: " + questionsNumber);

		percentage = (correctsAnw / questionsNumber) * 100;
		System.out.println("Rezultatul/procentul chestionarului este: " + percentage);
		return "answer";
	}

	/**
	 * Get the current answer
	 * @return answer
	 */ 
	public static String currentAnswer() {
		return answer;
	}

	/**
	 * Get all exams results(for student page/role)
	 * @return
	 */
	public String getExamsHistoric() {
		records = Records.getResultsForStudent();
		return "historic";
	}
	
	/**
	 * Get subject name and return the questionnaire page
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public String getExam() throws ParserConfigurationException, SAXException, IOException {
		subject = Subject.getSubject();
		return "questionnare";		
	}

}