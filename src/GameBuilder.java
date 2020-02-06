import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class GameBuilder {
    public Document getDocFromFile(String fileName)
            throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = null;

        try {
            doc = db.parse(fileName);
        } catch (Exception e) {
            System.out.println("ERROR: XML parse of file " + fileName);
        }

        return doc;
    }
}
