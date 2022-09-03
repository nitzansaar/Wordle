import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Wordle
{
    // creates a scanner for the file containing a list of words
   public static Scanner getFileHandle(String filename) {
       Scanner sc = null;
       try{
           File file = new File(filename);
           sc = new Scanner(file);

       } catch (FileNotFoundException e) {
           System.out.println("No such file");
           System.exit(-1);
       }
       return sc;
   }

    /* return a string representing the user's guess. If a letter is in the secret word, and it's in the right place,
        put a ! at that position. If a letter is in the secret word, but it's in the wrong place, put a 0. And if
        if's not present, put a X.
     */
   public static String compareWords(String secretWord, String guess) {
       String code = "";
        for (int i = 0, j = 1; i < guess.length(); i++, j++){
            String letter = guess.substring(i,j);
            String secretLetter = secretWord.substring(i,j);
            if(letter.equals(secretLetter)){
                code += "!";
            }else if (secretWord.contains(letter)){
                code += "0";
            }else{
                code += "X";
            }
        }
      // you do this part
        return code;
    }

    /* this method should call compareWords with multiple different inputs (same word,
    same letters but different position, completely different) to make aure it works.
    Return true if compareTwoWords does everything right, and false otherwise.
     */
   public static boolean testCompareWords() { // do you want me to create my own guesses to test this method?
        return false;
   }

    /*
    Select a random word from the file of legal words.
    Use the ArrayList to store the words, and then Random to
    select one.
     */
  public static String selectRandomWord(String wordfile) {
      ArrayList<String> words = new ArrayList<String>();
      Scanner input = getFileHandle(wordfile);
      for (int i = 0; i < 18; i++) {
          String temp = input.nextLine();
          words.add(temp);
      }
      Random generator = new Random();
      int random = generator.nextInt(18);
      return words.get(random);

  }


    /* testSelectRandomWord. This should call selectRandomWord and display the word
    that was selected.
     */

      public static void testSelectRandomWord() {
          String randomWord = selectRandomWord("wordleWords");
          System.out.println(randomWord);
      }
/*
Our primary method.
 */
      public static void playGame() {
          // Read a word from the file.
          // set a counter for the number of guesses so far.
          // loop:
          // prompt the user for a word.
          // Display the result.
          // Show the letters guessed so far
          Scanner input = new Scanner(System.in);
          String guess;
          String code;
          String secretWord;
          int count = 5;
          secretWord = selectRandomWord("wordleWords");
          System.out.println(secretWord);
          System.out.println("Welcome to worlde! Please enter your guess: ");
          guess = input.nextLine();
          code = compareWords(secretWord, guess);
          if (code.equals("!!!!!")){
              System.out.println(code);
              System.out.println("You win!");
          }else{
              do{
                  System.out.println(code);
                  System.out.println("remaining tries = " + count);
                  System.out.println("Try again");
                  guess = input.nextLine();
                  code = compareWords(secretWord, guess);
                  count--;
              }while (count > 0 && !code.equals("!!!!!"));
          }
          System.out.println("Thanks for playing");
      }

      public static void main(String args[]){
          //testSelectRandomWord();
          playGame();


      }


  }


