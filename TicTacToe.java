import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char playerSymbol, computerSymbol;
    static boolean playerTurn;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // UC1: Initialize and display 3x3 board with '-'
    static void initBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = '-';
    }

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

    // UC2: Toss to decide first player and assign symbols
    static void toss() {
        int result = random.nextInt(2); // 0 = player, 1 = computer
        if (result == 0) {
            playerSymbol = 'X';
            computerSymbol = 'O';
            playerTurn = true;
            System.out.println("You won the toss! You play as X and go first.");
        } else {
            playerSymbol = 'O';
            computerSymbol = 'X';
            playerTurn = false;
            System.out.println("Computer won the toss! Computer plays as X and goes first.");
        }
    }

    // UC3: Accept user slot input (1-9)
    static int getUserSlot() {
        int slot = -1;
        while (slot < 1 || slot > 9) {
            System.out.print("Enter slot (1-9): ");
            if (scanner.hasNextInt()) {
                slot = scanner.nextInt();
                if (slot < 1 || slot > 9)
                    System.out.println("Invalid. Must be 1-9.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
        return slot;
    }

    // UC4: Convert slot (1-9) to row and column indices
    static int[] slotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate move - row/col in bounds and cell empty
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == '-';
    }

    static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    static boolean isBoardFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == '-') return false;
        return true;
    }

    static void computerMove() {
        int slot;
        int[] idx;
        do {
            slot = random.nextInt(9) + 1;
            idx = slotToIndex(slot);
        } while (!isValidMove(idx[0], idx[1]));
        board[idx[0]][idx[1]] = computerSymbol;
        System.out.println("Computer chose slot " + slot);
    }

    public static void main(String[] args) {
        System.out.println("=== Tic-Tac-Toe: Human vs Computer ===");
        initBoard();
        printBoard();
        toss();

        while (true) {
            printBoard();
            if (playerTurn) {
                int slot;
                int[] idx;
                do {
                    slot = getUserSlot();
                    idx = slotToIndex(slot);
                    if (!isValidMove(idx[0], idx[1]))
                        System.out.println("Slot already taken. Try again.");
                } while (!isValidMove(idx[0], idx[1]));
                board[idx[0]][idx[1]] = playerSymbol;
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
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            playerTurn = !playerTurn;
        }
        scanner.close();
    }
}
