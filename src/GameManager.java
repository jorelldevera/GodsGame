import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class GameManager {

    Scanner sc = new Scanner(System.in);
    Globals globals = Globals.getInstance();
    Player p = new Player();
    Kingdom kingdom = new Kingdom();

    /**
     * Gets the player name, builds the world, calls start
     */
    public GameManager() {
        System.out.println("My name is Diya. What is your name?");
        System.out.print("> ");
        globals.setPlayerName(sc.nextLine());

        buildGame();
        start();
    }

    /**
     * uses the GameBuilder class to hydrate the kingdom
     */
    private void buildGame() {
        GameBuilder gameBuilder = null;
        try {
            gameBuilder = new GameBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        kingdom.setKingdom(gameBuilder.getKingdom());
        p.setCurrentRoom(1, 1);
    }

    /**
     * contains the game loop
     */
    private void start() {
        System.out.println("Stay alert, " + Globals.PLAYER_NAME + ". I'll be at your side.");

        // game loop
        while (true) {
            printOptions(getInputOptions());
            handleDecision(getDecision(getInputOptions()));
        }
    }

    /**
     * Uses room and player info to determine the player's options at any point in the game
     * @return an array list of strings, each one an option for the player
     */
    private ArrayList<String> getInputOptions() {
        /*
            player can move from BATTLE ROOM if
                it defeats all enemies in the room
            player can move from SHOP if
                whenever it wants
            player can move from POTS if
                whenever it wants
            player can move from PUZZLE if
                solves the puzzle
         */
        ArrayList<String> options = new ArrayList<String>();
        options.add("Exit room");
        options.add(("Quit"));
        return options;
    }

    /**
     * Prints options
     * @param options is an arraylist of string
     */
    private void printOptions(ArrayList<String> options) {
        Iterator<String> iter = options.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "\t");
        }
        System.out.println("");
    }

    /**
     * Asks the player to enter a decision
     * @param options is an arraylist of strings
     * @return a proper option
     */
    private String getDecision(ArrayList<String> options) {
        String decision = "";

        while (!options.contains(decision)) {
            System.out.println("Enter decision:");
            System.out.print("> ");
            decision = sc.nextLine();
            System.out.println();

            if (!options.contains(decision)) {
                System.out.println("That's not something you can do! (Decisions are case sensitive)");
            }
        }

        return decision;
    }

    /**
     * all decisions should enter this method completely lowercase
     */
    private void handleDecision(String decision) {
        switch (decision) {
            case "Exit room":
                exitRoom();
                break;
            case "Quit":
                System.out.println("bye bye!");
                System.exit(0);
        }
    }

    /**
     * moves the player from one room to the next
     */
    private void exitRoom() {
        System.out.println("You exit the room...");

        if (kingdom.getRealmOfRoom(p.getCurrentRoom() + 1) == p.getCurrentRealm()) {
            p.setCurrentRoom(p.getCurrentRoom() + 1);
        } else {
            p.setCurrentRoom(p.getCurrentRealm() + 1, p.getCurrentRoom() + 1);
        }

        // after this met
    }

}
