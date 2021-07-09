import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class Tests {

    @Test
    public void additionCheck() {
        Calculator calculator = new Calculator();
        double res = calculator.operation(2, 2, '+');
        assertEquals(4.0000, res, 0);
    }

    @Test
    public void subtractionCheck() {
        Calculator calculator = new Calculator();
        double res = calculator.operation(5.13f, 2, '-');
        assertEquals(3.13, res, 0.0001);
    }

    @Test
    public void divisionCheck() {
        Calculator calculator = new Calculator();
        double res = calculator.operation(45.9f, -5, '/');
        assertEquals(-9.18, res, 0.0001);
    }

    @Test
    public void multiplicationCheck() {
        Calculator calculator = new Calculator();
        double res = calculator.operation(-15.6f, -5.25f, '*');
        assertEquals(81.9, res, 0.0001);
    }

    @Test
    public void divisionByZero() {
        assertThrows(ArithmeticException.class, () -> new Calculator().operation(5, 0, '/'));
    }

    @Test
    public void checkNumberInput() {
        String inputData = "-5,1";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        assertEquals(-5.1, Calculator.getNumber(), 0.0001);
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void checkingStringTypeInput() {
        systemInMock.provideLines("1.78");
        assertThrows(InputMismatchException.class, () -> new Calculator().getNumber());
    }

    @Test
    public void checkLetterInput() {
        String inputData = "f";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        assertThrows(InputMismatchException.class, () -> new Calculator().getNumber());
    }

    @Test
    public void checkCharacterInput() {
        String inputData = "+";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        assertThrows(InputMismatchException.class, () -> new Calculator().getNumber());
    }
}
