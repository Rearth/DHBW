package sem02.de.dhbw.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Gazetter {

    public static void main(String[] args) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser;
            parser = factory.newDocumentBuilder();

            String url = "https://www.iai.kit.edu/~javavorlesung/karlsruhe.xml";
            Document doc = parser.parse(url);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            System.out.println(getFirst("formatted_address", doc));
            System.out.println(getFirst("long_name", doc));

            String location = doc.getElementsByTagName("location").item(0).getChildNodes().item(1).getTextContent();
            location += ", " + doc.getElementsByTagName("location").item(0).getChildNodes().item(3).getTextContent();

            String boundsA = doc.getElementsByTagName("southwest").item(0).getChildNodes().item(1).getTextContent();
            boundsA += ", " + doc.getElementsByTagName("southwest").item(0).getChildNodes().item(3).getTextContent();

            String boundsB = doc.getElementsByTagName("northeast").item(0).getChildNodes().item(1).getTextContent();
            boundsB += ", " + doc.getElementsByTagName("northeast").item(0).getChildNodes().item(3).getTextContent();
            System.out.println("location: " + location);
            System.out.println("bounds: " + boundsA + " | " + boundsB);
            //System.out.println(getFirst("bounds", doc));

            System.out.println("----------------------------");

            /*for (int i = 0; i < nList.getLength(); i++) {
                System.out.println(i + ": " + nList.item(i).getTextContent());
            }*/

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private static String getFirst(String tag, Document elem) {
        return elem.getElementsByTagName(tag).item(0).getTextContent();
    }

}
