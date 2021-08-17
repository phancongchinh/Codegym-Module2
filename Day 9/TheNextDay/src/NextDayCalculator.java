import java.time.LocalDate;

public class NextDayCalculator {
    public static LocalDate getTheNextDay(LocalDate localDate){
//        throw new UnsupportedOperationException();
        return localDate.plusDays(1);
    }
}
