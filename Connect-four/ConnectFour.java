public class ConnectFour {
    private final char[][] board;
    private final int rows = 6;
    private final int columns = 7;
    private final char emptySlot = '.';

    public ConnectFour() {
        board = new char[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = emptySlot;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == emptySlot) {
                return false;
            }
        }
        return true;
    }

    public boolean dropDisc(int column, char disc) {
        if (column < 0 || column >= columns || board[0][column] != emptySlot) {
            return false;
        }
        for (int i = rows - 1; i >= 0; i--) {
            if (board[i][column] == emptySlot) {
                board[i][column] = disc;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char disc) {
        // Check horizontal, vertical, and diagonal win conditions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (checkDirection(i, j, 1, 0, disc) ||
                    checkDirection(i, j, 0, 1, disc) ||
                    checkDirection(i, j, 1, 1, disc) ||
                    checkDirection(i, j, 1, -1, disc)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int rowDir, int colDir, char disc) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + i * rowDir;
            int c = col + i * colDir;
            if (r >= 0 && r < rows && c >= 0 && c < columns && board[r][c] == disc) {
                count++;
            } else {
                break;
            }
        }
        return count == 4;
    }
}