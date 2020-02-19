import java.util.ArrayList;

public class Realm {

    private int level;
    private String name;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public Realm (String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(int roomnum) {
        for (Room room: rooms) {
            if (room.getNumber() == roomnum) {
                return room;
            }
        }

        return null;
    }

    public boolean isRoomNumInRealm(int roomnum) {
        for (Room room: rooms) {
            if (room.getNumber() == roomnum) {
                return true;
            }
        }

        return false;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
