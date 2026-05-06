# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC4 — Convert Slot Number (1–9) to Board Index

**Goal:** Convert a user-entered slot number into row and column indices for the 2D board array.

**Actor:** Human Player / Game System

**Flow:**
```
Slot (1–9) entered → slotToIndex() → row & col generated → board accessed
```

**Key Concepts:**
- Zero-based indexing
- Mathematical mapping using division and modulo
- Utility method design

**Methods:**
| Method | Description |
|--------|-------------|
| `slotToIndex(int slot)` | Returns `int[]{row, col}` where `row=(slot-1)/3`, `col=(slot-1)%3` |

**Slot → Index Mapping:**
```
 1 | 2 | 3        [0][0] | [0][1] | [0][2]
 4 | 5 | 6   →   [1][0] | [1][1] | [1][2]
 7 | 8 | 9        [2][0] | [2][1] | [2][2]
```

**Formula:**
```java
row = (slot - 1) / 3
col = (slot - 1) % 3
```

**Sample Output:**
```
Enter slot (1-9): 5
Slot 5 → row=1, col=1
```

**Branch:** `uc4-slot-to-index` | Builds on: `uc3-user-input`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` ← **you are here** | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move + full game |
