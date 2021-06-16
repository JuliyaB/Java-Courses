package task_3_2;

import java.util.Scanner;

/**
 * @author Juliya Bondarenko
 */

public class ArrayWords {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Running a class task_3_2.ArrayWords.
     */
    public static void start() {
        System.out.print("Enter the number of words: ");
        int length = scanner.nextInt();
        workaround();
        System.out.print("Longest word: " + getLongestWord(getInputWord(length)));
        scanner.close();
    }

    /**
     * In this method, words are entered into the array.
     *
     * @param length word length
     * @return returns an array of words
     */
    public static String[] getInputWord(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter a word: ");
            array[i] = scanner.nextLine();
        }
        return array;
    }

    /**
     * Finding the longest word in an array.
     *
     * @param array an array of words
     * @return returns the longest word found in the array
     */
    public static String getLongestWord(String[] array) {
        int maxLength = 0;
        String longestWord = null;
        for (String word : array) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }
        return longestWord;
    }

    /**
     * Fix error reading nextline after nextInt.
     */
    public static void workaround() {
        scanner.nextLine();
    }

}
