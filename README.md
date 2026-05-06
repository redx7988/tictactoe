# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC9 — Check Winning Condition

**Goal:** Detect if a player has won the game after each move.

**Actor:** Game System

**Flow:**
```
Move placed (UC6) → checkWin(symbol) → rows checked
→ columns checked → diagonals checked → win detected or continue
```

**Key Concepts:**
- Pattern Matching
- Logical Conditions
- Loop-Based Checks (rows and columns)
- Hardcoded Diagonal Checks

**Method:**
| Method | Description |
|--------|-------------|
| `checkWin(char symbol)` | Returns `true` if symbol fills any row, column, or diagonal |

**Win Patterns Checked:**
```
Rows:        [r][0]==[r][1]==[r][2]  for r in 0,1,2
Columns:     [0][c]==[1][c]==[2][c]  for c in 0,1,2
Diagonal 1:  [0][0]==[1][1]==[2][2]
Diagonal 2:  [0][2]==[1][1]==[2][0]
```

**Sample Output:**
```
| X | O | X |
| - | X | O |
| - | - | X |

You win!
```

**Branch:** `uc9-check-win` | Builds on: `uc8-game-loop`

---

## Full Game — All Use Cases (UC1–UC9)

**How to Run:**
```bash
javac src/TicTacToe.java
java -cp src TicTacToe
```

**All Methods:**
| Method | UC | Description |
|--------|----|-------------|
| `initBoard()` | UC1 | Initialize 3×3 board with `'-'` |
| `printBoard()` | UC1 | Print board with nested loops |
| `toss()` | UC2 | Randomly assign X/O and first turn |
| `getUserSlot()` | UC3 | Read valid slot input (1–9) |
| `slotToIndex(slot)` | UC4 | Convert slot → row/col |
| `isValidMove(row, col)` | UC5 | Check bounds and empty cell |
| `placeMove(row, col, symbol)` | UC6 | Update board with symbol |
| `computerMove()` | UC7 | Random valid computer move |
| `playGame()` | UC8 | Turn-based loop until win/draw |
| `checkWin(symbol)` | UC9 | Detect win via rows/cols/diagonals |

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move (bounds + empty cell) |
| `uc6-place-move` | UC6 | Place move on board |
| `uc7-computer-move` | UC7 | Computer random move |
| `uc8-game-loop` | UC8 | Turn-based game loop |
| `uc9-check-win` ← **you are here** | UC9 | Check winning condition + full game |
