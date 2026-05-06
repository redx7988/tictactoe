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

    public static void main(String[] args) {
        System.out.println("=== Tic-Tac-Toe ===");
        initBoard();
        printBoard();
        toss();
        System.out.println("Player: " + playerSymbol + " | Computer: " + computerSymbol);

        int slot  = getUserSlot();
        int[] idx = slotToIndex(slot);
        System.out.println("Slot " + slot + " → row=" + idx[0] + ", col=" + idx[1]);
        scanner.close();
    }
}
