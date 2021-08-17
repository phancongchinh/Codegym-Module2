import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    @DisplayName("test ngày kế tiếp")
    void getTheNextDay() {
        LocalDate localDate = LocalDate.parse("2020-01-01");
        LocalDate expected = LocalDate.parse("2020-01-02");

        LocalDate result = NextDayCalculator.getTheNextDay(localDate);
        assertEquals(expected, result);
    }
}