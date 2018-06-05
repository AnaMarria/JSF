package managedbean;

import java.io.Serializable;

public class Record implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String score;
	private String subject;

	public Record () {
		
	}
	
	public Record(int id, String name, String score, String subject) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.subject = subject;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
}
