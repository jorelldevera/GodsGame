public class Player {

    int currentRealm;
    int currentRoom;

    public Player () {

    }

    public int getCurrentRealm() {
        return this.currentRealm;
    }

    public void setCurrentRoom(int realm, int room) {
        this.currentRealm = realm;
        this.currentRoom = room;
    }

    public void setCurrentRoom(int room) {
        this.currentRoom = room;
    }

    public int getCurrentRoom() {
        return this.currentRoom;
    }
}
