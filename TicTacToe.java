import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // UC1: Board state
    static char[][] board = new char[3][3];

    // UC2: Player/game state
    static char playerSymbol, computerSymbol;
    static boolean playerTurn;
    static Random random = new Random();

    // UC3: Scanner for user input
    static Scanner scanner = new Scanner(System.in);

    // UC1: Initialize all cells with '-'
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

    // UC2: Toss to randomly assign symbols and decide first player
    static void toss() {
        int result = random.nextInt(2);
        if (result == 0) {
            playerSymbol   = 'X';
            computerSymbol = 'O';
            playerTurn     = true;
            System.out.println("You won the toss! You play as X and go first.");
        } else {
            playerSymbol   = 'O';
            computerSymbol = 'X';
            playerTurn     = false;
            System.out.println("Computer won the toss! Computer plays as X and goes first.");
        }
    }

    // UC3: Read a valid slot number (1-9) from user
    static int getUserSlot() {
        int slot = -1;
        while (slot < 1 || slot > 9) {
            System.out.print("Enter slot (1-9): ");
            if (scanner.hasNextInt()) {
                slot = scanner.nextInt();
                if (slot < 1 || slot > 9)
                    System.out.println("Invalid. Must be between 1 and 9.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return slot;
    }

    // UC4: Convert slot (1-9) to row and column using division and modulo
    static int[] slotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate move — row/col must be 0-2 and cell must be empty
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row <= 2
            && col >= 0 && col <= 2
            && board[row][col] == '-';
    }

    // UC6: Place a symbol on the board at the given row and column
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer makes a random valid move
    static void computerMove() {
        int[] idx;
        do {
            idx = slotToIndex(random.nextInt(9) + 1);
        } while (!isValidMove(idx[0], idx[1]));
        placeMove(idx[0], idx[1], computerSymbol);
        System.out.println("Computer placed '" + computerSymbol + "'");
    }

    // UC9: Check winning condition — rows, columns, and both diagonals
    static boolean checkWin(char symbol) {
        for (int r = 0; r < 3; r++)
            if (board[r][0] == symbol && board[r][1] == symbol && board[r][2] == symbol)
                return true;
        for (int c = 0; c < 3; c++)
            if (board[0][c] == symbol && board[1][c] == symbol && board[2][c] == symbol)
                return true;
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    // UC10: Detect draw — count empty cells using loop traversal and boolean flag
    static boolean isDraw() {
        int emptyCells = 0;                          // counting logic
        for (int r = 0; r < 3; r++)                  // loop traversal
            for (int c = 0; c < 3; c++)
                if (board[r][c] == '-') emptyCells++;
        boolean noMovesLeft = (emptyCells == 0);     // boolean flag
        return noMovesLeft && !checkWin(playerSymbol) && !checkWin(computerSymbol);
    }

    // UC8: Continuous turn-based game loop
    static void playGame() {
        while (true) {
            printBoard();

            if (playerTurn) {
                int slot;
                int[] idx;
                do {
                    slot = getUserSlot();
                    idx  = slotToIndex(slot);
                    if (!isValidMove(idx[0], idx[1]))
                        System.out.println("Slot already taken. Try another.");
                } while (!isValidMove(idx[0], idx[1]));
                placeMove(idx[0], idx[1], playerSymbol);

                if (checkWin(playerSymbol)) {
                    printBoard();
                    System.out.println("You win!");
                    break;
                }
            } else {
                computerMove();
                if (checkWin(computerSymbol)) {
                    printBoard();
                    System.out.println("Computer wins!");
                    break;
                }
            }

            if (isDraw()) {                          // UC10
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            playerTurn = !playerTurn;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Tic-Tac-Toe: Human vs Computer ===");
        initBoard();
        printBoard();
        toss();
        playGame();
        scanner.close();
    }
}
