import java.util.Scanner;

public class FizzBuzz {
    public static final String ILLEGAL = "The number must be a positive integer less than 100!";
    public static final String POSITIVE_INTEGER = "a positive integer: ";
    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        do {
            request(POSITIVE_INTEGER);
            int number = scanner.nextInt();
            System.out.println(fizzBuzz(number));
            System.out.println(readOutLoud(number));
        } while (choice != 0);
    }

    public static String fizzBuzz(int number){
        String result = "" + number;
        boolean numberIsNotPositive = number <= 0;
        if (numberIsNotPositive) {
            throw new IllegalArgumentException(ILLEGAL);
        } else {
            boolean numberIsDivisibleBy15 = number % 15 == 0;
            if (numberIsDivisibleBy15){
                result = FIZZ + BUZZ;
            } else {
                boolean numberIsDivisibleBy3 = number % 3 == 0;
                if (numberIsDivisibleBy3) {
                    result = FIZZ;
                } else {
                    boolean numberIsDivisibleBy5 = number % 5 == 0;
                    if (numberIsDivisibleBy5){
                        result = BUZZ;
                    }
                }
            }
        }
        return result;
    }

    public static String readOutLoud(int number){
        int unit = number % 10;
        int tenth = (number - unit) / 10;
        String result;
        if (number < 10) {
            result = readOutLoudOneDigit(number);
        } else {
            result = readOutLoudOneDigit(tenth) + " " + readOutLoudOneDigit(unit);
        }

        return result;
    }

    public static String readOutLoudOneDigit(int digit){
        String result = "";
        switch (digit){
            case 0:
                result = "khong";
                break;
            case 1:
                result = "mot";
                break;
            case 2:
                result = "hai";
                break;
            case 3:
                result = "ba";
                break;
            case 4:
                result = "bon";
                break;
            case 5:
                result = "nam";
                break;
            case 6:
                result = "sau";
                break;
            case 7:
                result = "bay";
                break;
            case 8:
                result = "tam";
                break;
            case 9:
                result = "chin";
                break;
        }
        return result;
    }

    public static void request(String description){
        System.out.println("Enter " + description);
    }
}
