import java.util.Scanner;
public class GameManager {

    Scanner sc = new Scanner(System.in);
    Globals globals = Globals.getInstance();

    public GameManager() {
        System.out.println("My name is Diya. What is your name?");
        System.out.print("> ");
        globals.setPlayerName(sc.nextLine());

        buildGame();
        start();
    }

    private void buildGame() {
        GameBuilder gameBuilder = new GameBuilder();
    }

    private void start() {
        System.out.println("Stay alert, " + Globals.PLAYER_NAME + ". Go forth and I will aid you.");

    }
}
