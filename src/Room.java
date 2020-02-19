public abstract class Room {

    Globals globals = Globals.getInstance();

    private String name;
    private String desc;
    private Globals.RoomType type; // BATTLE, SHOP, PUZZLE, or POTS
    private int number; // each room has a number

    public Room (String name, String desc, Globals.RoomType type) {
        this.name = name;
        this.desc = desc;
        this.type = type;
    }

    public Room (String name, Globals.RoomType type, int number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
