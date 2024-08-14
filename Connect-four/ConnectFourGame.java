import java.util.Scanner;

public class ConnectFourGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConnectFour game = new ConnectFour();
        char currentPlayer = 'X';
        boolean gameWon = false;

        while (!game.isFull() && !gameWon) {
            game.displayBoard();
            System.out.println("Player " + currentPlayer + ", choose a column (1-7): ");
            int column = scanner.nextInt() - 1;

            if (!game.dropDisc(column, currentPlayer)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (game.checkWin(currentPlayer)) {
                game.displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        if (!gameWon) {
            game.displayBoard();
            System.out.println("The game is a draw!");
        }

        scanner.close();
    }
}
