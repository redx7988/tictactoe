# TicTacToe-App

Console-based Tic-Tac-Toe game (Human vs Computer) — Java.

---

## UC8 — Continuous Turn-Based Game Loop

**Goal:** Continue gameplay by alternating turns until a win or draw is detected.

**Actor:** Game System

**Flow:**
```
Turn starts → player/computer makes move → check draw
→ switch turn → repeat (win check added in UC9)
```

**Key Concepts:**
- While Loop (runs until game ends)
- Game State Flags (`playerTurn` boolean)
- Turn Switching (`playerTurn = !playerTurn`)

**Method:**
| Method | Description |
|--------|-------------|
| `playGame()` | Main while loop — alternates turns, stops on draw |
| `isBoardFull()` | Returns `true` when no `'-'` cells remain |

**Loop Structure:**
```
while (true) {
    printBoard()
    if (playerTurn) → player move (UC3→UC4→UC5→UC6)
    else            → computerMove() (UC7)
    if (isBoardFull) → draw → break
    playerTurn = !playerTurn
}
```

**Branch:** `uc8-game-loop` | Builds on: `uc7-computer-move`

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
| `uc8-game-loop` ← **you are here** | UC8 | Turn-based game loop |
| `uc9-check-win` | UC9 | Check winning condition + full game |
