package managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dao.LoginDAO;
import mail.SendEmail;
import mail.TrySendEmail;
import managedbean.SessionUtils;


@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String username;
	private String password;
	private String userrole;

	public Login() {
	}

	public Login(String username, String password, String userrole) {
		this.username = username;
		this.password = password;
		this.userrole = userrole;

	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Validate user credentials
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws MessagingException 
	 * @throws NamingException 
	 */
	public String validateAuthentification() throws ParserConfigurationException, SAXException, IOException, NamingException, MessagingException {
		boolean valid = LoginDAO.validate(username, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);

			String role = LoginDAO.getUserRole(username);

			if (role.equals("admin")) {
				// send email with link
//				SendEmail.testSendMail();
//				TrySendEmail.test();
				return "admin";
			} else if (role.equals("student")) {
				return "student";
			} else {
				return "index";
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "index";
		}
	}


	/**
	 * Logout event, invalidate session
	 * 
	 * @return
	 */
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index";
	}

}