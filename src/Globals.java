/**
 * Globals
 *
 * This is a singleton class used to store global variables.
 */
public class Globals {

    // One singleton instance
    private static Globals instance;

    /* VARIABLES */
    public static String PLAYER_NAME;

    /* CONSTANTS */
    public static String KINGDOM_XML = "Resources/world.xml";
    public static String KINGDOM_NAME = "Egypt";
    public static int NUM_REALMS = 4;

    /**
     * Determines each type of room
     */
    public enum RoomType {
        BATTLE, SHOP, PUZZLE, POTS
    }

    /**
     * @param roomType is a String of a roomtype
     * @return the proper roomtype that correlates to the string
     */
    public static RoomType stringToRoomType (String roomType) {
        switch (roomType) {
            case "BATTLE":
                return RoomType.BATTLE;
            case "SHOP":
                return RoomType.SHOP;
            case "PUZZLE":
                return RoomType.PUZZLE;
            case "POTS":
                return RoomType.POTS;
            default:
                System.out.println("ERROR stringToRoomType: invalid input: \"" + roomType + "\"");
                System.exit(-1);
        }

        return null;
    }

    public static Globals getInstance() {
        if (instance == null) {
            instance = new Globals();
        }

        return instance;
    }

    /* ACCESSORS AND MUTATORS */

    public void setPlayerName(String playerName) {
        PLAYER_NAME = playerName;
    }

    public String getPlayerName() {
        return PLAYER_NAME;
    }

    public Globals() {

    }
}
