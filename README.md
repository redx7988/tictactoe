# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC2 — Toss to Decide First Player and Symbol

**Goal:** Randomly decide who plays first and assign symbols (X or O).

**Actor:** Game System

**Flow:**
```
Game starts → toss() → assign X/O → set playerTurn
```

**Key Concepts:**
- Random Number Generation (`Random.nextInt(2)`)
- Conditional logic for symbol assignment
- Game state variables (`playerSymbol`, `computerSymbol`, `playerTurn`)

**Methods:**
| Method | Description |
|--------|-------------|
| `toss()` | Randomly assigns X/O and decides who goes first |

**Sample Output:**
```
You won the toss! You play as X and go first.
Player: X | Computer: O
```
or
```
Computer won the toss! Computer plays as X and goes first.
Player: O | Computer: X
```

**Branch:** `uc2-toss` | Builds on: `uc1-display-board`

---

## Branch Progression

| Branch | UC | Feature |
|--------|----|---------|
| `uc1-display-board` | UC1 | Display empty board |
| `uc2-toss` ← **you are here** | UC2 | Toss to decide first player |
| `uc3-user-input` | UC3 | Accept user slot input (1–9) |
| `uc4-slot-to-index` | UC4 | Convert slot to row/col index |
| `uc5-validate-move` | UC5 | Validate move + full game |
