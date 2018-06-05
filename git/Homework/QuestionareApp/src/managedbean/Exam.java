package managedbean;

import java.io.Serializable;

import managedbean.Questionare;

public class Exam implements Serializable {
	private String subject, question, firstanswer, secondanswer, thirdanswer, fourthanswer, correctanswer;

	private static final long serialVersionUID = 1L;

	private int correctAnswers;

	public Exam() {
	}

	public Exam(String question, String firstanswer, String secondanswer, String thirdanswer, String fourthanswer,
			String correctanswer) {
		this.question = question;
		this.firstanswer = firstanswer;
		this.secondanswer = secondanswer;
		this.thirdanswer = thirdanswer;
		this.fourthanswer = fourthanswer;
		this.correctanswer = correctanswer;
	}
	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getFirstanswer() {
		return firstanswer;
	}

	public void setFirstanswer(String firstanswer) {
		this.firstanswer = firstanswer;
	}

	public String getSecondanswer() {
		return secondanswer;
	}

	public void setSecondanswer(String secondanswer) {
		this.secondanswer = secondanswer;
	}

	public String getThirdanswer() {
		return thirdanswer;
	}

	public void setThirdanswer(String thirdanswer) {
		this.thirdanswer = thirdanswer;
	}

	public String getFourthanswer() {
		return fourthanswer;
	}

	public void setFourthanswer(String fourthanswer) {
		this.fourthanswer = fourthanswer;
	}

	public String getCorrectanswer() {
		return correctanswer;
	}

	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}

	private static double count = 0;

	public void increment() {
		count++;
	}

	public static double getCount() {
		return count;
	}

	public void setCount(int name) {
		this.count = name;
	}


	/**
	 * Validate questionnaire answer
	 */
	public void validateAnswer() {
		System.out.println(correctanswer);
		String currentAnswer = Questionare.currentAnswer();
		
		if (currentAnswer.equals(correctanswer)) {
			System.out.println("VICTORIE");
			increment();
		} else {
			System.out.println("Ghinion");
		}
	}
	
}
