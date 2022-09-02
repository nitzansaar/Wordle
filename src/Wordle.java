import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    public static Scanner getFileHandle(String filename) {
    // you fill this in.
    }

    /* return a string representing the user's guess. If a letter is in the secret word, and it's in the right place,
        put a ! at that position. If a letter is in the secret word, but it's in the wrong place, put a 0. And if
        if's not present, put a X.
     */
    public static String compareWords(String secretWord, String guess) {
        String result = new String(5);
      // you do this part
        return result;
    }

    /* this method should call compareWords with multiple different inputs (same word,
    same letters but different position, completely different) to make aure it works.
    Return true if compareTwoWords does everything right, and false otherwise.
     */
    public static boolean testCompareWords() {

    }

    /*
    Select a random word from the file of legal words.
    Use the ArrayList to store the words, and then Random to
    select one.
     */
    public static String selectRandomWord(String wordfile) {
        ArrayList<String> words = new ArrayList<String>();
      // you do this part.
    }

    /* testSelectRandomWord. This should call selectRandomWord and display the word
    that was selected.
     */

    public static void testSelectRandomWord() {

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


    }


    public static void main(String args[]) {




    }

}
