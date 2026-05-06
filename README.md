# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC3 — Accept User Slot Input (1–9)

**Goal:** Allow the user to enter a valid slot number between 1 and 9.

**Actor:** Human Player

**Flow:**
```
User enters slot → Scanner reads input → validate range → return slot
```

**Key Concepts:**
- User Input Handling (`Scanner`)
- Method creation and separation of concerns
- Input validation with re-prompt loop

**Methods:**
| Method | Description |
|--------|-------------|
| `getUserSlot()` | Reads integer input, re-prompts if invalid, returns valid slot (1–9) |

**Validation Rules:**
- Input must be an integer
- Value must be in range `1–9`
- Non-integer or out-of-range → re-prompt

**Sample Output:**
```
Enter slot (1-9): 0
Invalid. Must be between 1 and 9.
Enter slot (1-9): abc
Invalid input. Please enter a number.
Enter slot (1-9): 5
You entered slot: 5
```

**Branch:** `uc3-user-input` | Builds on: `uc2-toss`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` | UC2 | Toss to decide first player |
| `uc3-user-input` ← **you are here** | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move + full game |
