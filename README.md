# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## How to Run

```bash
open TicTacToe.java file on an ide and run it and play game in your terminal
```

---

## Use Cases

| UC | Branch | Goal |
|----|--------|------|
| UC1 | [`uc1-display-board`](https://github.com/redx7988/tictactoe/tree/uc1) | Display empty 3x3 board |
| UC2 | [`uc2-toss`](https://github.com/redx7988/tictactoe/tree/uc2). | Toss to decide first player and assign symbols |
| UC3 | [`uc3-user-input`](https://github.com/redx7988/tictactoe/tree/uc3) | Accept user slot input (1-9) |
| UC4 | [`uc4-slot-to-index`](https://github.com/redx7988/tictactoe/tree/uc4) | Convert slot number to board row/col index |
| UC5 | [`uc5-validate-move`](https://github.com/redx7988/tictactoe/tree/uc5) | Validate move (bounds + empty cell) |
| UC6 | [`uc6-place-move`](https://github.com/redx7988/tictactoe/tree/uc6) | Place move on board |
| UC7 | [`uc7-computer-move`](https://github.com/redx7988/tictactoe/tree/uc7) | Computer makes a random valid move |
| UC8 | [`uc8-game-loop`](https://github.com/redx7988/tictactoe/tree/uc8) | Continuous turn-based game loop |
| UC9 | [`uc9-check-win`](https://github.com/redx7988/tictactoe/tree/uc9) | Check winning condition |
| UC10 | [`uc10-detect-draw`](https://github.com/redx7988/tictactoe/tree/uc10) | Detect draw condition + full game |

---

## UC1 — Display Empty Board

**Flow:** `initBoard() -> printBoard()`
**Concepts:** 2D Array, Initialization, Nested Loops

| Method | Description |
|--------|-------------|
| `initBoard()` | Fills all 9 cells with '-' |
| `printBoard()` | Prints board with nested loops |

---

## UC2 — Toss to Decide First Player and Symbol

**Flow:** `toss() -> assign X/O -> set playerTurn`
**Concepts:** Random Number Generation, Conditional Logic, Game State

| Method | Description |
|--------|-------------|
| `toss()` | `Random.nextInt(2)` assigns symbols and decides who goes first |

---

## UC3 — Accept User Slot Input (1-9)

**Flow:** `Scanner reads input -> validate range -> return slot`
**Concepts:** User Input Handling, Separation of Concerns

| Method | Description |
|--------|-------------|
| `getUserSlot()` | Reads integer input, re-prompts if invalid |

---

## UC4 — Convert Slot (1-9) to Board Index

**Flow:** `slotToIndex(slot) -> row & col`
**Concepts:** Zero-based Indexing, Division and Modulo

```
row = (slot - 1) / 3      col = (slot - 1) % 3

 1 | 2 | 3        [0][0] | [0][1] | [0][2]
 4 | 5 | 6   ->   [1][0] | [1][1] | [1][2]
 7 | 8 | 9        [2][0] | [2][1] | [2][2]
```

---

## UC5 — Validate User Move

**Flow:** `isValidMove(row, col) -> accepted or rejected`
**Concepts:** Boundary Checking, Defensive Programming

| Method | Description |
|--------|-------------|
| `isValidMove(row, col)` | `true` if row/col are 0-2 and cell is '-' |

---

## UC6 — Place Move on Board

**Flow:** `placeMove(row, col, symbol) -> board updated`
**Concepts:** State Update, Array Indexing, Reusable Methods

| Method | Description |
|--------|-------------|
| `placeMove(row, col, symbol)` | Sets `board[row][col] = symbol` |

---

## UC7 — Computer Makes a Random Move

**Flow:** `random slot -> slotToIndex() -> isValidMove() loop -> placeMove()`
**Concepts:** Random Generation, do-while Loop, Logic Reuse

| Method | Description |
|--------|-------------|
| `computerMove()` | Picks random valid slot, places computer symbol |

---

## UC8 — Continuous Turn-Based Game Loop

**Flow:** `while -> player/computer move -> win/draw check -> switch turn`
**Concepts:** While Loop, Game State Flags, Turn Switching

| Method | Description |
|--------|-------------|
| `playGame()` | Main loop — alternates turns, stops on win/draw |

---

## UC9 — Check Winning Condition

**Flow:** `checkWin(symbol) -> rows -> columns -> diagonals`
**Concepts:** Pattern Matching, Logical Conditions, Loop-Based Checks

| Method | Description |
|--------|-------------|
| `checkWin(symbol)` | Checks 3 rows, 3 columns, 2 diagonals for a win |

```
Rows:        [r][0]==[r][1]==[r][2]   for r in 0,1,2
Columns:     [0][c]==[1][c]==[2][c]   for c in 0,1,2
Diagonal 1:  [0][0]==[1][1]==[2][2]
Diagonal 2:  [0][2]==[1][1]==[2][0]
```

---

## UC10 — Detect Draw Condition

**Flow:** `count empty cells -> noMovesLeft flag -> no winner -> draw`
**Concepts:** Counting Logic, Loop Traversal, Boolean Flags

| Method | Description |
|--------|-------------|
| `isDraw()` | Counts empty cells; `true` if 0 empty cells and no winner |

---

## All Methods Summary

| Method | UC | Description |
|--------|----|-------------|
| `initBoard()` | UC1 | Initialize 3x3 board with '-' |
| `printBoard()` | UC1 | Print board with nested loops |
| `toss()` | UC2 | Randomly assign X/O and first turn |
| `getUserSlot()` | UC3 | Read valid slot input (1-9) |
| `slotToIndex(slot)` | UC4 | Convert slot to row/col |
| `isValidMove(row, col)` | UC5 | Check bounds and empty cell |
| `placeMove(row, col, symbol)` | UC6 | Update board with symbol |
| `computerMove()` | UC7 | Random valid computer move |
| `playGame()` | UC8 | Turn-based loop until win/draw |
| `checkWin(symbol)` | UC9 | Detect win via rows/cols/diagonals |
| `isDraw()` | UC10 | Detect draw via empty cell count |
