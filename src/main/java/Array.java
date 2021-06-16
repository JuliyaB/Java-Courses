import java.util.Arrays;
import java.util.Random;

import javafx.util.Pair;

/**
 * @author Juliya Bondarenko
 */

public class Array {

    public static void main(String[] args) {
        Integer[] array = getArray();
        System.out.println("An array of 20 dimensions, filled with random numbers from -10 to 10: "
                + Arrays.toString(array));
        Pair maxNegativeNumber = getMaxNegativeNumber(array);
        Pair minPositiveNumber = getMinPositiveNumber(array);
        System.out.println("Maximum negative is: " + maxNegativeNumber.getValue());
        System.out.println("Minimal positive is: " + minPositiveNumber.getValue());
        System.out.println("Modified array: " + Arrays.toString(getModifiedArray(array, (Integer) minPositiveNumber.getKey()
                , (Integer) maxNegativeNumber.getKey())));
    }

    /**
     * Filling an array with random numbers from 10 to -10
     *
     * @return returns a filled array
     */
    public static Integer[] getArray() {
        Random random = new Random();
        Integer[] array = new Integer[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.ints(-10, 11)
                    .findFirst()
                    .getAsInt();
        }
        return array;
    }

    /**
     * We are looking for the maximum negative number in the array
     *
     * @param array filled array
     * @return returns the maximum negative number found in an array
     */
    public static Pair getMaxNegativeNumber(Integer[] array) {
        int maxNegative = Integer.MIN_VALUE;
        int negative = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] < 0) && (maxNegative < array[i])) {
                maxNegative = array[i];
                negative = i;
            }
        }
        return new Pair(negative, maxNegative);
    }

    /**
     * We are looking for the minimum positive number in the array
     *
     * @param array filled array
     * @return returns the minimum positive number found in an array
     */
    public static Pair getMinPositiveNumber(Integer[] array) {
        int minPositive = Integer.MAX_VALUE;
        int positive = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 0) && (minPositive > array[i])) {
                minPositive = array[i];
                positive = i;
            }
        }
        return new Pair(positive, minPositive);
    }

    /**
     * Swap the maximum negative number and the minimum positive number in the array in places
     *
     * @param array    filled array
     * @param positive the index of the minimum positive number
     * @param negative the index of the maximum negative number
     * @return returns a modified array
     */
    public static Integer[] getModifiedArray(Integer[] array, int positive, int negative) {
        int temp;
        temp = array[negative];
        array[negative] = array[positive];
        array[positive] = temp;
        return array;
    }

}
