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
        System.out.print("Enter the expression: ");
        Expression expression = new Expression(scanner.next());
        System.out.printf("Result: %.4f", expression.getResult());
        scanner.close();
    }
}