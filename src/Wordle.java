import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Nitzan Saar Assignment 1
 */
public class Wordle
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    //
    public static void updateScore(int wins, int losses)
    {
        File file = new File("totalScore");
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);// no idea what this is
        }
        out.write("Wins: " + wins + "\nLosses: " + losses);
        out.close();

    }
    // returns a scanner for the file containing a list of words
   public static Scanner getFileHandle(String filename)
   {
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
   public static String compareWords(String secretWord, String guess)
   {
       String code = new String();
        for (int i = 0, j = 1; i < guess.length(); i++, j++)
        {
            String letter = guess.substring(i,j);
            String secretLetter = secretWord.substring(i,j);
            if(letter.equalsIgnoreCase(secretLetter))
            {
                code += "!";
            }else if (secretWord.contains(letter))
            {
                code += "0";
            }else
            {
                code += "X";
            }
        }
        return code;
    }

    /* this method should call compareWords with multiple different inputs (same word,
    same letters but different position, completely different) to make aure it works.
    Return true if compareTwoWords does everything right, and false otherwise.
     */
   public static boolean testCompareWords()
   {
       String result = compareWords("Hello", "Hello");
       String result2 = compareWords("Hello", "12345");
       String result3 = compareWords("Hello", "Great");
       System.out.println("Should be \"!!!!!\": " + result);
       System.out.println("Should be \"XXXXX\": " + result2);;
       System.out.println("Should be \"XX0XX\": " + result3);
       return (result.equals("!!!!!"));
   }

    /*
    Select a random word from the file of legal words.
    Use the ArrayList to store the words, and then Random to
    select one.
     */
  public static String selectRandomWord(String wordfile)
  {
      ArrayList<String> words = new ArrayList<String>();
      Scanner input = getFileHandle(wordfile);
      for (int i = 0; i < 18; i++)
      {
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

      public static void testSelectRandomWord()
      {
          String randomWord = selectRandomWord("wordleWords");
          System.out.println(randomWord);
      }

/*
Our primary method.
 */
      public static void playGame()
      {
          Scanner input = new Scanner(System.in);
          String guessedLetters = "";
          String guess;
          String result;
          String secretWord;
          String answer;
          int count = 5;
          int wins = 0;
          int losses = 0;

          System.out.print("Welcome to Worlde! Do you want to play?(Y/N): ");
          answer = input.nextLine();
          if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes")) // the user decides if they wish to play or not
          {
              do
              {
                  secretWord = selectRandomWord("wordleWords");// generate a random word and store it into variable "secretWord"
                  //System.out.println(secretWord); to test
                  System.out.print("Please enter a 5 letter word: ");
                  guess = input.nextLine();
                  while (guess.length() != 5)
                  { // loop to ensure the user enters a 5-letter word
                      System.out.print("That's not a 5 letter word, try again: ");
                      guess = input.nextLine();
                  }
                  result = compareWords(secretWord, guess);
                  if (result.equals("!!!!!"))
                  {
                      System.out.println("First try!");
                  } else
                  {
                      do
                      {
                          guessedLetters += guess.toUpperCase() + "|"; // stores all the guesses into a single string
                          System.out.println(ANSI_PURPLE + result + ANSI_RESET);
                          System.out.print("Guessed: ");
                          for (int i = 0; i < guessedLetters.length(); i++)
                          {// loop to neatly print out the guessed letters separated by a space
                              System.out.print(guessedLetters.charAt(i) + " ");
                          }
                          System.out.println("\nRemaining tries: " + count);
                          System.out.print("Try again: ");
                          guess = input.nextLine();
                          while (guess.length() != 5)
                          {// error detection loop to ensure user enters 5-letter word
                              System.out.print("That's not a 5 letter word, try again: ");
                              guess = input.nextLine();
                          }
                          result = compareWords(secretWord, guess);
                          count--;
                      } while (count > 0 && !result.equals("!!!!!"));// stay in the loop if the user still has guesses remaining and the user hasn't guessed correctly
                  }
                  System.out.println(ANSI_PURPLE + result + ANSI_RESET);

                  if (result.equals("!!!!!"))
                  {
                      System.out.println("Congrats, you won!!!");
                      wins++;
                  } else
                  {
                      System.out.println("Better luck next time! The word was \"" + secretWord.toUpperCase() + "\"");
                      losses++;
                  }
                  System.out.println("--------------------------------");
                  System.out.print("Do you want to play again?(Y?N): ");
                  answer = input.nextLine();
                  count = 5; //reset the count
                  guessedLetters = ""; //reset the guesses
              }while(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes"));
          }
          updateScore(wins, losses);
          System.out.println("Wins: " + wins + "\nLosses: " + losses); // display the wins and losses
          System.out.print("Have a nice day :-)");
      }


      public static void main(String args[])
      {
          /*System.out.print("Random word: ");
          testSelectRandomWord();
          boolean test = testCompareWords();
          System.out.println(test);*/
          playGame();


      }


  }


