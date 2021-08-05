import java.util.Scanner;

public class IsLeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year:");
        int year = sc.nextInt();
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 ==0;
        } else {
            return year % 4 == 0;
        }
    }
}
