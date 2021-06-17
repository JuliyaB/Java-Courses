package task_3;

import task_3.calculator.Calculator;
import task_3.task_3_2.ArrayWords;

import java.util.Scanner;

/**
 * @author Juliya Bondarenko
 */

public class Running {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        scanner.close();
    }

    /**
     * User input of selected option.
     */
    public static void input() {
        System.out.print("1 - Calculator.Calculator\n" +
                "2 - Finding the maximum word in an array\n" +
                "Enter 1 or 2: ");
        switch (scanner.nextInt()) {
            case 1:
                Calculator.start();
                break;
            case 2:
                ArrayWords.start();
                break;
            default:
                input();
                break;
        }
    }
}
