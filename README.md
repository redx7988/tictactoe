# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC1 — Display Empty Board

**Goal:** Display an empty 3×3 Tic-Tac-Toe board on the console.

**Actor:** User

**Flow:**
```
User runs program → initBoard() → printBoard()
```

**Key Concepts:**
- 2D Array (`char[3][3]`) for board representation
- Initialization logic (`'-'` = empty cell)
- Nested loops for console output

**Methods:**
| Method | Description |
|--------|-------------|
| `initBoard()` | Fills all 9 cells with `'-'` |
| `printBoard()` | Prints the board with nested loops |

**Sample Output:**
```
=== Tic-Tac-Toe ===

| - | - | - |
| - | - | - |
| - | - | - |
```

**Branch:** `uc1-display-board`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` ← **you are here** | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move + full game |
