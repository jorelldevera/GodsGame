import java.util.ArrayList;

public class Kingdom {
    private ArrayList<Realm> kingdom = new ArrayList<Realm>();

    public ArrayList<Realm> getKingdom() {
        return kingdom;
    }

    public void setKingdom(ArrayList<Realm> kingdom) {
        this.kingdom = kingdom;
    }

    public Room getRoom (int realm, int roomnum) {
        return kingdom.get(realm - 1).getRoom(roomnum);
    }

    /**
     * Gets the realm number of the passed room number
     * @param roomnum room that we want to find the realm of
     * @return the number of the realm corresponding to the roomnum
     */
    public int getRealmOfRoom(int roomnum) {
        for (Realm r : kingdom) {
            if (r.isRoomNumInRealm(roomnum)) {
                return r.getLevel();
            }
        }

        return -1;
    }
}
