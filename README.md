# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC7 — Computer Makes a Random Move (Easy Level)

**Goal:** Allow the computer to make a random valid move.

**Actor:** Computer Player

**Flow:**
```
Computer turn → random slot (1-9) generated → slotToIndex() (UC4)
→ isValidMove() (UC5) → loop until valid → placeMove() (UC6)
```

**Key Concepts:**
- Random Generation (`Random.nextInt(9) + 1`)
- Loop Until Valid (do-while)
- Logic Reuse (UC4, UC5, UC6 all reused)

**Method:**
| Method | Description |
|--------|-------------|
| `computerMove()` | Generates random slot, validates, places computer symbol |

**Sample Output:**
```
Computer placed 'O'

| X | - | - |
| - | O | - |
| - | - | - |
```

**Branch:** `uc7-computer-move` | Builds on: `uc6-place-move`

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
| `uc7-computer-move` ← **you are here** | UC7 | Computer random move |
| `uc8-game-loop` | UC8 | Turn-based game loop |
| `uc9-check-win` | UC9 | Check winning condition + full game |
