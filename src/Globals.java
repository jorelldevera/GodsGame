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
    public static String WORLD_NAME = "Gebanna";

    /**
     * Determines each type of room
     */
    public enum RoomType {
        BATTLE, SHOP, PUZZLE, POTS
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
