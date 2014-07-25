package XO;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();

        game.newGame();
        game.playGame();

        System.out.println(game.getWinner());
    }

}
