# Wordle Game Project

This repository contains the code for a simple Wordle game implemented in Java. The game challenges players to guess a secret word within a limited number of tries. As players submit their guesses, the game provides feedback to indicate correct letters in the correct position (!), correct letters in the wrong position (0), and incorrect letters (X).

## How to Play

1. Clone or download the repository to your local machine.

2. Compile and run the `Wordle` class to start the game.

3. The game will select a random word for you to guess. You'll have up to 5 tries to guess the word.

4. Enter a 5-letter word as your guess. The game will provide feedback after each guess.

5. The feedback consists of:
   - `!`: Correct letter in the correct position.
   - `0`: Correct letter in the wrong position.
   - `X`: Incorrect letter.

6. Keep guessing until you've either guessed the word or used all your tries.

7. After each game, you'll be asked if you want to play again. Enter 'Y' or 'N' to continue or quit the game.

## Running the Code

1. Compile the code:

javac Wordle.java

2. Run the game:

java Wordle

## Additional Information

- The `wordleWords` file contains a list of words from which the game selects a secret word.

- The game tracks your wins and losses and updates the score in the `totalScore` file.

## What I Learned

While working on this project, I learned:
- How to read and manipulate files in Java.
- How to implement a simple game loop and user input handling.
- How to use string manipulation to compare words and provide feedback.
- How to work with arrays, lists, and random number generation.

Feel free to explore the code and experiment with the game. If you have any questions or suggestions for improvements, feel free to open an issue or contact me.

Have fun playing Wordle!

