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

        int count = maxWordCount(words);
        System.out.println("Max count: " + count);
        System.out.println("Most recurring words: ");
        ArrayList<String> maxWords = maxWords(words, count);
        for (String word : maxWords) {
            System.out.print(word + " ");
        }
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
            System.out.println(e.getMessage());
        }
        return wordAndQuantity;
    }

    /**
     * Search for the most common word count
     *
     * @param words collection of words
     * @return most recurring word count
     */
    public static int maxWordCount(Map<String, Integer> words) {
        int count = 0;
        for (String word : words.keySet()) {
            if (count < words.get(word)) {
                count = words.get(word);
            }
        }
        return count;
    }

    /**
     * Search for the list of words by count
     *
     * @param words collection of words
     * @param count encounters in the text
     * @return all words with so many encounters in the text
     */
    public static ArrayList<String> maxWords(Map<String, Integer> words, int count) {
        ArrayList<String> maxWords = new ArrayList<>();
        for (String word : words.keySet()) {
            if (count == words.get(word)) {
                maxWords.add(word);
            }
        }
        return maxWords;
    }
}
