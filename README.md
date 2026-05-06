# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC6 — Place Move on Board

**Goal:** Update the board with the player's or computer's symbol at the chosen position.

**Actor:** Human Player / Computer Player

**Flow:**
```
Valid move confirmed (UC5) → placeMove() → board updated
```

**Key Concepts:**
- State Update
- Array Indexing
- Reusable Methods (called by both player and computer)

**Method:**
| Method | Description |
|--------|-------------|
| `placeMove(int row, int col, char symbol)` | Sets `board[row][col] = symbol` |

**Sample Output:**
```
Enter slot (1-9): 5
Placed 'X' at row=1, col=1

| - | - | - |
| - | X | - |
| - | - | - |
```

**Branch:** `uc6-place-move` | Builds on: `uc5-validate-move`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move (bounds + empty cell) |
| `uc6-place-move` ← **you are here** | UC6 | Place move on board |
| `uc7-computer-move` | UC7 | Computer random move |
| `uc8-game-loop` | UC8 | Turn-based game loop |
| `uc9-check-win` | UC9 | Check winning condition + full game |
