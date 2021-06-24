import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/**
 * @author Juliya Bondarenko
 */

public class WordsInFile {

    public static void main(String[] args) {
        Map<String, Integer> words = readFilesAndCount("./src/main/resources/text.txt");
        System.out.println("Sorted words in alphabetical order and their number in the text:");
        for (String word : words.keySet()) {
            System.out.println(word + " " + words.get(word));
        }
        System.out.println("Most recurring word: " + maxWord(words));
    }

    /**
     * Reading from a file, counting the number of words
     *
     * @param filename the path to the file
     * @return sorted words and their number
     */
    public static Map<String, Integer> readFilesAndCount(String filename) {
        Map<String, Integer> wordAndQuantity = new TreeMap<>();
        try {
            for (String line : Files.readAllLines(new File(filename).toPath(), Charset.defaultCharset())) {
                String[] split = line.split("\\s+");
                for (String word : split) {
                    if (!wordAndQuantity.containsKey(word)) {
                        wordAndQuantity.put(word.toLowerCase(), 0);
                    }
                    wordAndQuantity.put(word.toLowerCase(), wordAndQuantity.get(word) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return wordAndQuantity;
    }

    /**
     * Search for the most common word and its number
     *
     * @param words collection of words
     * @return most recurring word and its number
     */
    public static String maxWord(Map<String, Integer> words) {
        String maxWord = null;
        int count = 0;
        for (String word : words.keySet()) {
            if (count < words.get(word)) {
                count = words.get(word);
                maxWord = word + " " + count;
            }
        }
        return maxWord;
    }

}
