import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Juliya Bondarenko
 */

public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Running a class Calculator.
     */
    public static void start() {
        try {
            System.out.print("Enter the number: ");
            float firstNumber = scanner.nextFloat();
            System.out.print("Enter the number: ");
            float secondNumber = scanner.nextFloat();
            System.out.printf("Result: %.4f", operation(firstNumber, secondNumber));
            scanner.close();
        }catch (InputMismatchException ex){
            System.out.println("An error occurred while entering a number.");
        }
    }

    /**
     * In this method, the user enters the operation he wants to carry out with numbers.
     * The entered value goes through the case, if it matches, it enters the enum Operation and returns the answer from there.
     *
     * @param firstNumber  first entered number
     * @param secondNumber second entered number
     */
    public static float operation(float firstNumber, float secondNumber) {
        System.out.print("Enter operation: ");
        switch (scanner.next().charAt(0)) {
            case '+':
                return Operation.ADDITION.action(firstNumber, secondNumber);
            case '-':
                return Operation.SUBTRACTION.action(firstNumber, secondNumber);
            case '/':
                return Operation.DIVISION.action(firstNumber, secondNumber);
            case '*':
                return Operation.MULTIPLICATION.action(firstNumber, secondNumber);
            default:
                return operation(firstNumber, secondNumber);
        }
    }

}