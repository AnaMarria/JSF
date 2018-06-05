package xmlReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AllQuestionTags {

	public static int getQuestionNumber() throws ParserConfigurationException, SAXException, IOException {
		ArrayList testNo = new ArrayList();

		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File(
				"C:/Users/paras/Downloads/glassfish-4.0/glassfish4/glassfish/domains/domain1/config/exams.xml"));

		// Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

		// Get all exams
		NodeList nList = document.getElementsByTagName("exam");
		
		System.out.println("============================");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			System.out.println("");
			if (node.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) node;
				testNo.add(eElement.getElementsByTagName("question").item(0).getTextContent());
				System.out.println("First Name : " + eElement.getElementsByTagName("question").item(0).getTextContent());
			}
		}

		System.out.println(testNo.size());
		return testNo.size();
	}
}
