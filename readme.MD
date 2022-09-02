Due: September 9 at the start of class.

The GitHub Classroom link for this assignment can be found here: 

To turn in: commit all of your code to your github repo by the deadline.

In this homework, you'll get some experience writing a Java program that can 
handle user input, read from file, and use loops, conditionals and static methods.

All code should be well-formatted,
with no extraneous or commented-out code. Please include your name in a comment
at the top of Wordle.java.

This homework will be graded using specifications grading. 
There are a sequence of tasks to complete. 
Grades will be assigned as follows: 

- To receive a C, you should complete tasks 1,2,3,4,5
- To receive a B, complete all the C-level tasks, plus 6 and 7
- To receive an A, complete the B-level tasks, plus *either* task 8 or task 9.


We'll implement a simplified version of the popular game Wordle. 
If you haven't tried Wordle, you can play  it [here](https://www.nytimes.com/games/wordle/index.html).

 The game works like this:
The computer picks a hidden five-letter word.

The player has six tries to guess the word. After each guess, they're told:
- Letters that are in the word and in the right place (marked with a !)
- Letters that are in the word, but in the wrong place (marked with a O)
- Letters that are not in the word. (marked with a X)

So, for example, if the hidden word was MATCH and the player guessed TRASH, the computer would display XXOX!


To keep it simple, let's only use words without repeated letters. (no GEESE or TRUST).

I've provided you with some starter code; your job is to fill in the blanks.

Part 1. Implement the getFileHandle method. This should take as input a filename and return an
opened Scanner for that file.

Part 2. Implement selectRandomWord. It should take as input a filename, call getFileHandle to open the file,
read all the words into an ArrayList, choose one at random, and return it.

Part 3. Let's write our first test method. 
It should be called testSelectRandomWord. 
It should call selectRandomWord with both a valid and an invalid filename and make sure it works correctly.
Call your test function within main().

Part 4: Now we'll implement compareWords. It should take two arguments: a secret word and a guess. It should return a new string representing the results of the user's guess, as described above.

Part 5: Now let's write testCompareWords. It should call compareWords with a variety of different inputs to ensure that it works.

Part 6: Now we're ready to build the game itself. We'll do this inside playGame(). Play game should:
- Call selectRandomWord to get a word.
- Use a loop to give the user six guesses. Prompt the user, and then use a Scanner to read their guesss.
- For each guess, display the result of compareWords.
- If they get it right, tell them they've won.
- If they use all six guesses, they have lost.

Call playGame() from main. (you'll probably want to comment out your test code.)

Part 7: Let's help the user out a little and keep track of the letters they've already guessed.
Create a String called guessedLetters inside playGame. Every time the use makes a guess, add their guess to the string and display the guessed letters.

Part 8: We can make this look a little nicer by using color. [This link](https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/)
 shows how to do this. Modify your game to use different colors for letters in the result of compareWords.

Part 9: Let's keep track of the user's performance. Use a file called totalScore to store two numbers - the number of wins and losses.
At the end of each game, update this file and display the user's total number of wins and losses.