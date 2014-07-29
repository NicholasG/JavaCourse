import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.newGame();

        System.out.println("Choose a game mode: 1 -- with human; 2 -- with computer.");
        int mode = scanner.nextInt();
        if (mode == 1) {
            game.playWithHuman();
        } else if (mode == 2) {
            game.playWithComputer();
        }

        System.out.println(game.getWinner());
    }

}
