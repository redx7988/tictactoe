public class TicTacToe {

    // UC1: 3x3 board represented as a 2D char array
    static char[][] board = new char[3][3];

    // UC1: Initialize all cells with '-' (empty)
    static void initBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = '-';
    }

    // UC1: Print the board using nested loops
    static void printBoard() {
        System.out.println();
        for (int r = 0; r < 3; r++) {
            System.out.print("| ");
            for (int c = 0; c < 3; c++)
                System.out.print(board[r][c] + " | ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Tic-Tac-Toe ===");
        initBoard();
        printBoard();
    }
}
