package XO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private static final int TO_WIN = 3;

    private static final int SIZE = 3;

    private static final char DEFAULT = '*';

    private char[][] XO = new char[SIZE][SIZE];

    private String  winner = "Draw.";

    public String getWinner() {
        return winner;
    }

    public void newGame() {
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                XO[i][j] = DEFAULT;
                System.out.print("\t" + XO[i][j]);
            }

            System.out.println();
        }
    }

    public void playGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        while (true) {

            System.out.println("Write position (x; y) X: ");
            int y = Integer.parseInt(reader.readLine());
            int x = Integer.parseInt(reader.readLine());
            XO[x - 1][y - 1] = 'X';
            i++;

            for (int j = 0; j < SIZE; j++) {

                for (int k = 0; k < SIZE; k++) {
                    System.out.print("\t" + XO[j][k]);
                }

                System.out.println();
            }

            if (i >= SIZE * SIZE) break;
            if (whoWin()) break;

            System.out.println("Write position (x; y) O: ");
            y = Integer.parseInt(reader.readLine());
            x = Integer.parseInt(reader.readLine());
            XO[x - 1][y - 1] = 'O';

            for (int j = 0; j < SIZE; j++) {

                for (int k = 0; k < SIZE; k++) {
                    System.out.print("\t" + XO[j][k]);
                }

                System.out.println();
            }

            if (whoWin()) break;

            i++;
        }
    }

    private boolean whoWin() {
        //Пошук по горизонталі
        for (int i = 0; i < SIZE; i++) {
            int kx = 0;
            int ko = 0;

            for (int j = 0; j < SIZE; j++) {

                if (XO[i][j] == 'X') {
                    kx++;
                }

                if (XO[i][j] == 'O') {
                    ko++;
                }
            }

            if (kx == TO_WIN) {
                winner = "1st player win!";
                return true;
            } else if (ko == TO_WIN) {
                winner = "2 player win!";
                return true;
            }
        }

        //Пошук по вертикалі
        for (int i = 0; i < SIZE; i++) {
            int kx = 0;
            int ko = 0;

            for (int j = 0; j < SIZE; j++) {

                if (XO[j][i] == 'X') {
                    kx++;
                }

                if (XO[j][i] == 'O') {
                    ko++;
                }
            }

            if (kx == TO_WIN) {
                winner = "1st player win!";
                return true;
            } else if (ko == TO_WIN) {
                winner = "2 player win!";
                return true;
            }
        }

        //Пошук по головній діагоналі
        int kx = 0;
        int ko = 0;
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                if (XO[i][j] == 'X' && i == j) {
                    kx++;
                }

                if (XO[i][j] == 'O' && i == j) {
                    ko++;
                }
            }

            if (kx == TO_WIN) {
                winner = "1st player win!";
                return true;
            } else if (ko == TO_WIN) {
                winner = "2 player win!";
                return true;
            }
        }

        //Пошук по бічній діагоналі
        kx = 0;
        ko = 0;
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                if (XO[i][j] == 'X' && j == (SIZE - i - 1)) {
                    kx++;
                }

                if (XO[i][j] == 'O' && j == (SIZE - i - 1)) {
                    ko++;
                }
            }

            if (kx == TO_WIN) {
                winner = "1st player win!";
                return true;
            } else if (ko == TO_WIN) {
                winner = "2 player win!";
                return true;
            }
        }

        return false;
    }

}
