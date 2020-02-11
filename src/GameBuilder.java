import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class GameBuilder {

    private Document doc;

    public GameBuilder() throws ParserConfigurationException {
        this.setDocFromFile();
    }

    private void setDocFromFile()
            throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        try {
            this.doc = db.parse(Globals.KINGDOM_XML);
        } catch (Exception e) {
            System.out.println("ERROR: XML parse of file " + Globals.KINGDOM_XML);
            System.exit(0);
        }
    }

    /**
     *
     * @return an arraylist of realms
     */
    public ArrayList<Realm> getKingdom() {
        NodeList realmList = this.doc.getElementsByTagName("realm");
        ArrayList<Realm> kingdom = new ArrayList<Realm>();

        for (int i = 0; i < realmList.getLength(); i++) {
            Node realmNode = realmList.item(i);
            Element realmElement = (Element) realmNode;

            // building new realm
            Realm r = new Realm(realmElement.getAttribute("name"), Integer.parseInt(realmElement.getAttribute("level")));
            r.setRooms(getRooms(realmElement));

            // add realm to list
            kingdom.add(r);
        }
    }

    private ArrayList<Room> getRooms(Element realmElement) {
        NodeList roomList = realmElement.getElementsByTagName("room");
        ArrayList<Room> rooms = new ArrayList<Room>();

        for (int i = 0; i < roomList.getLength(); i++) {
            Node roomNode = roomList.item(i);
            Element roomElement = (Element) roomNode;

            // building new room
            // Room r = new Room(roomElement.getAttribute("name"), /* description */, Globals.stringToRoomType(realmElement.getAttribute("type")));
            Room r = new Room(roomElement.getAttribute("name"), Globals.stringToRoomType(realmElement.getAttribute("type")));

            // add room to list
            rooms.add(r);
        }
    }
}
