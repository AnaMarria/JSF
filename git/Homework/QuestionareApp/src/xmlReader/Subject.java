package xmlReader;

import java.io.File;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Subject {
	static String thisSubject;
	

	public static String getSubject() throws ParserConfigurationException, SAXException, IOException {
		
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File("C:/Users/paras/Downloads/glassfish-4.0/glassfish4/glassfish/domains/domain1/config/exams.xml"));

		// Here comes the root node
		Element root = document.getDocumentElement();
		thisSubject = root.getAttribute("id");
		return thisSubject;
	}
}
