# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC10 — Detect Draw Condition

**Goal:** Detect when no moves remain and no winner exists.

**Actor:** Game System

**Flow:**
```
Board checked → loop counts empty cells → noMovesLeft flag set
→ no winner confirmed → draw declared
```

**Key Concepts:**
- Counting Logic (count empty '-' cells)
- Loop Traversal (nested for loops over board)
- Boolean Flag (noMovesLeft = emptyCells == 0)

**Method:**
| Method | Description |
|--------|-------------|
| `isDraw()` | Counts empty cells; returns `true` if 0 empty cells and no winner |

**Logic:**
```java
int emptyCells = 0;
for each cell: if '-' -> emptyCells++
boolean noMovesLeft = (emptyCells == 0);
return noMovesLeft && !checkWin(player) && !checkWin(computer);
```

**Sample Output:**
```
| X | O | X |
| X | O | O |
| O | X | X |

It's a draw!
```

**Branch:** `uc10-detect-draw` | Builds on: `uc9-check-win`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1-9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move (bounds + empty cell) |
| `uc6-place-move` | UC6 | Place move on board |
| `uc7-computer-move` | UC7 | Computer random move |
| `uc8-game-loop` | UC8 | Turn-based game loop |
| `uc9-check-win` | UC9 | Check winning condition |
| `uc10-detect-draw` - YOU ARE HERE | UC10 | Detect draw condition + full game |
