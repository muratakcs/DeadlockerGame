# Deadlocker Game - Discrete Mathematics II Programming Assignment 2

## 📌 Overview

This project is a **graph-based movement game** where students implement a strategy to **get stuck as early as possible** in a grid-based game. The player starts at a **given position** and moves according to the **rules of movement**, avoiding deleted squares and walls.

Each student must create a **Java class** that extends `Player.java` and implements the `nextMove()` method to determine their movement strategy.

## 📂 Project Structure

```
DeadlockerGame/
|│—— src/
|│   ├—— game/
|│   │   ├—— Board.java             # Game board logic
|│   │   ├—— Move.java              # Represents a move in the game
|│   │   ├—— Player.java            # Abstract base class for students
|│   │   ├—— Referee.java           # Handles game execution and validation
|│   │   ├—— InstanceGenerator.java # Generates random game instances
|│   │   ├—— GameLogger.java        # Logs game results
|│   │   └—— Tester.java            # Runs student submissions
|│   └—— players/
|│       ├—— Player12345.java       # A player
|│       ├—— Player67890.java       # Another player
|│       └—— ...                    # other players...
|├—— students.txt                   # List of student IDs
|├—— boards/                        # Stores game instances for fair testing
|├—— results/                       # Stores game results per player
|├—— snapshots/                     # Stores game step-by-step visual logs (optional)
|├—— run_tests.sh                   # Automates compilation and execution
|└—— README.md                      # This file
```

## 🎮 **Game Rules**

### **🔢 Grid Layout**

* The game takes place on an **N × N** board with each cell containing a **number (1-9)**.
* The **starting position** of the player is **randomly chosen** for each test.
* The **goal** is to get stuck as quickly as possible, i.e., make the **minimum number of moves** before no valid moves remain.

### **🔄 Movement Rules**

1. **The player moves in one of 8 directions:**

   * **N, S, E, W (↑ ↓ → ←)**
   * **NW, NE, SW, SE (↖ ↗ ↙ ↘)**
2. Your submitted code must return a move direction (N, NE, E, SE, S, SW, W, NW) as a `Move`. **The movement distance is determined by the first number in that direction.**
3. **A move is valid only if:**

   * The player can really move towards the target direction without going out of the boundaries or crossing a previously visited (deleted) square.
   * The player does not pass through or land on a **deleted cell**.
4. **Cells traversed during a move are deleted (replaced by " ").**
5. **The game ends when no valid moves remain.**

## 📌 **Submission Instructions**

* **DO NOT** push your `Player<yourStudentID>.java` file to this repository.
* Submit your `Player<yourStudentID>.java` file through **the designated submission system**.
* Your filename must be **exactly** `Player<yourStudentID>.java`.
* Your submission will be tested on multiple board instances stored in `boards/`.
* Any unauthorized access or sharing of solutions will be considered plagiarism.

## 📌 **Example Submission (`Player12345.java`)**

```java
package players;

import game.*;
import java.util.List;

public class Player12345 extends Player {
    public Player12345(Board board) {
        super(board);
    }
    
    @Override
    public Move nextMove() {
        List<Move> possibleMoves = board.getPossibleMoves();
        return possibleMoves.isEmpty() ? null : possibleMoves.get(0); // Always pick first move
    }
}
```

## 📌 **Running the Tests**

### **Option 1: Run Manually**

```sh
javac -d bin src/game/*.java src/players/*.java
java -cp bin game.Tester
```

### **Option 2: Use the Automated Script**

```sh
chmod +x run_tests.sh  # (Only needed once)
./run_tests.sh         # Runs the script
```

* The script **compiles all Java files** and executes each player's code.
* Game instances are pre-generated in the `boards/` directory.
* Results will be stored in `results/Player<studentID>.log`.
* A summary of total move counts will be stored in `results/TotalMoves.txt`.
* Step-by-step game snapshots (if enabled) will be saved in `snapshots/`.

## 📌 **Rules & Guidelines**

### **✅ Do's**

✔ **Implement** your own unique strategy.
✔ **Follow** the movement rules strictly.
✔ **Test** your code before submitting.
✔ **Timeout limits:**

* Constructor Timeout (≥2 sec) Fails immediately. Player gets a max move count (i.e., worst score).
* Move Timeout (≥1 sec per move) Stops playing after timeout, retains move count so far.

### **❌ Don'ts**

❌ **Modify game logic files (`Board.java`, `Referee.java`, etc.).** Report issues to the instructor.
❌ **Try to access other students' submissions or plagiarize.**

## 📌 **Scoring & Evaluation**

* Your **score** is the **number of valid moves made before getting stuck**.
* **Lower scores are better.** The fewer the moves, the more efficient your strategy.
* If your program **makes an invalid move**, the game **ends immediately**, and your score remains at that step.
* If your program **fails to compile**, your score will be **zero**.
* If your program **crashes at runtime**, you will receive a **minimal participation score of 1**.
* If your program **exceeds the time limit**, the game ends, and your score remains at that step.
* If your program **takes too long to initialize**, it will be disqualified with a score of **zero**.

Your final score will be **reported as an average of total move counts** across multiple boards. The lowest total move count wins.

## 📌 **Contact**

For any issues, contact the instructor or the teaching assistant.
