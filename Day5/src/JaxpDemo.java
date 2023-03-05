import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JaxpDemo {
    public static void main(String[] args) {
        final String FILE_NAME = "StudentList.xml";
        File studentListXml = new File(FILE_NAME);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(studentListXml);
            document.getDocumentElement().normalize();
            NodeList students = document.getElementsByTagName("students");
            for (int studentCount = 0; studentCount < students.getLength(); studentCount++) {
                Node student = students.item(studentCount);
                if (student.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) student;
                    System.out.println("Name = " + element.getAttribute("firstName")
                            + " " + element.getAttribute("lastName")
                            + " Age = " + element.getAttribute("age"));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
