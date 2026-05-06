# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC5 — Validate User Move

**Goal:** Ensure the chosen slot is within bounds and the cell is not already taken.

**Actor:** Game System

**Flow:**
```
Row & col received → isValidMove() → accepted or rejected → re-prompt if invalid
```

**Key Concepts:**
- Conditional logic and boundary checking
- Defensive programming
- Integration with UC3 (input) and UC4 (index conversion)

**Methods:**
| Method | Description |
|--------|-------------|
| `isValidMove(int row, int col)` | Returns `true` if row/col are 0–2 **and** cell equals `'-'` |

**Validation Rules:**
- `row` must be `0, 1, or 2`
- `col` must be `0, 1, or 2`
- `board[row][col]` must be `'-'` (empty)

**Sample Output:**
```
Enter slot (1-9): 5
Slot taken. Try another.
Enter slot (1-9): 3
```

---

## Full Game — All Use Cases Combined

This branch contains the complete playable Tic-Tac-Toe game integrating UC1–UC5.

**How to Run:**
```bash
javac src/TicTacToe.java
java -cp src TicTacToe
```

**Game Flow:**
```
1. Board initialized and displayed (UC1)
2. Toss assigns symbols and first turn (UC2)
3. Player enters slot 1-9 (UC3)
4. Slot converted to row/col (UC4)
5. Move validated before placing (UC5)
6. Repeat until win or draw
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

**Branch:** `uc5-validate-move` | Builds on: `uc4-slot-to-index`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` ← **you are here** | UC5 | Validate move + full game |
