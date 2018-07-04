package sem02.de.dhbw.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Grid {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        double pointsA[][] = new double[5][5];
        double pointsB[][] = new double[5][5];
        double pointA = 48.9404298;
        double pointB = 8.2774096;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pointsA[i][j] = pointA + 100 * 5;
                pointsB[i][j] = pointB + 100 * 5;
            }
        }

        System.out.println("created points, creating document...");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.newDocument();
        Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
        Element document = doc.createElement("Document");
        kml.appendChild(document);
        doc.appendChild(kml);

        System.out.println("creating markers");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Element elem = doc.createElement("Placemark");
                document.appendChild(elem);

                Element name = doc.createElement("name");
                name.setTextContent("DHBW");
                elem.appendChild(name);
                Element pos = doc.createElement("Point");
                elem.appendChild(pos);
                Element coords = doc.createElement("coordinates");
                pos.appendChild(coords);
                coords.setTextContent(pointsA[i][j] + "," + pointsB[i][j]);
            }
        }

        System.out.println("setting up transformer...");

        TransformerFactory tFactory = TransformerFactory.newInstance();
        tFactory.setAttribute("indent-number", 4);
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("grid.kml"));
        transformer.transform(source, result);

        System.out.println("done, filepath: " + new File("grid.kml").getAbsolutePath());

    }

}
