package mail;

import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.*;

public class TrySendEmail {

	public static void test() throws NamingException, MessagingException{
		try {
			InitialContext ic = new InitialContext();
			String snName = "java:comp/env/mail/MyMailSession";
			Session session = (Session)ic.lookup(snName);
			
			Properties props = session.getProperties();
			props.put("mail.from", "");
			
			Message msg = new MimeMessage(session);
			String msgSubject = "Subject test";
			msg.setSubject(msgSubject);
			msg.setSentDate(new Date());
			msg.setFrom();
			String msgRecipient = "Recipient test";
			msg.setRecipients(Message.RecipientType.TO, 
			   InternetAddress.parse(msgRecipient, false));
			String msgTxt = "Mesage test";
			msg.setText(msgTxt);
			
			Transport.send(msg);
			

		} catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	
	}
}
