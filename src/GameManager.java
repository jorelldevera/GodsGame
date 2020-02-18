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

    public GameManager() {
        System.out.println("My name is Diya. What is your name?");
        System.out.print("> ");
        globals.setPlayerName(sc.nextLine());

        buildGame();
        start();
    }

    private void buildGame() {
        GameBuilder gameBuilder = null;
        try {
            gameBuilder = new GameBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        kingdom.setKingdom(gameBuilder.getKingdom());
    }

    private void start() {
        System.out.println("Stay alert, " + Globals.PLAYER_NAME + ". Go forth and I will aid you.");
        while (true) {
            printOptions(getInputOptions());
            handleDecision(getDecision(getInputOptions()));
        }
    }

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

        return options;
    }

    private void printOptions(ArrayList<String> options) {
        Iterator<String> iter = options.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "\t");
        }
        System.out.println("");
    }

    private String getDecision(ArrayList<String> options) {
        String decision = "";

        while (!options.contains(decision)) {
            //printOptions(options);
            System.out.println("Enter decision:");
            System.out.print("> ");
            decision = sc.nextLine();
        }

        return decision;
    }

    /**
     * all decisions should enter this method completely lowercase
     */
    private void handleDecision(String decision) {
        switch (decision) {
            case "exit room":
                exitRoom();
                break;
        }
    }

    /**
     * moves the player from one room to the next
     */
    private void exitRoom() {

    }

}
