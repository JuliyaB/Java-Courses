import org.junit.Test;

import static org.junit.Assert.*;


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
}
