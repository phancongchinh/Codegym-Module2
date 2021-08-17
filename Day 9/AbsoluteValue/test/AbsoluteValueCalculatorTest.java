import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbsoluteValueCalculatorTest {

    @Test
    @DisplayName("case 0")
    void testFindAbsoluteValue0() {
        int number = 0;
        int expected = 0;

        int result = AbsoluteValueCalculator.findAbsoluteValue(number);
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("case positive")
    void testFindAbsoluteValuePositive() {
        int number = 5;
        int expected = 5;

        int result = AbsoluteValueCalculator.findAbsoluteValue(number);
        assertEquals(expected,result);
    }
    @Test
    @DisplayName("case negative")
    void testFindAbsoluteValueNegative() {
        int number = -5;
        int expected = 5;

        int result = AbsoluteValueCalculator.findAbsoluteValue(number);
        assertEquals(expected,result);
    }


}