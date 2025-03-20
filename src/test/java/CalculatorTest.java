import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculateTotalCost() {
        Calculator calc = new Calculator();
        double[] prices = {1.0, 2.0, 3.0};
        int[] quantities = {1, 2, 3};
        assertEquals(14.0, calc.CalculateTotalCost(3, prices, quantities));
    }
}