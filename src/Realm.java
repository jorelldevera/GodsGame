import java.util.ArrayList;

public class Realm {

    private int level;
    private String name;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public Realm (String name, int level) {
        this.name = name;
        this.level = level;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
