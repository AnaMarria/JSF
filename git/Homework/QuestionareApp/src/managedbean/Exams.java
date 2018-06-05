package managedbean;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Exams {
 
	/**
	 * Get exam questions and answers from xml file
	 * @return
	 */
	public ArrayList getExams() {

		ArrayList al = new ArrayList();
		Exam exm;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();

			File fXmlFile = new File("exams.xml");

			Document document = builder.parse(fXmlFile);
			Element root = document.getDocumentElement();
			
			NodeList exams = root.getChildNodes();

			for (int i = 0; i < exams.getLength(); i++) {
				if (exams.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;

				NodeList examdetails = exams.item(i).getChildNodes();

				exm = new Exam(examdetails.item(1).getTextContent(), examdetails.item(3).getTextContent(),
						examdetails.item(5).getTextContent(), examdetails.item(7).getTextContent(),
						examdetails.item(9).getTextContent(), examdetails.item(11).getTextContent());
				al.add(exm); 
				Collections.shuffle(al);
			}

			return al;
		} catch (Exception e) {
			System.out.println("\n** Parsing error" + ", line " + e.getMessage());
			return null;
		}
	}
}
