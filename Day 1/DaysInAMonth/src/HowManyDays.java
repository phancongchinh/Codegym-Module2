import java.util.Scanner;

public class HowManyDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of month: ");
        String month = sc.next();
        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                System.out.println(month + " has 31 days!");
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                System.out.println(month + " has 30 days!");
                break;
            case "February":
                System.out.println(month + " has 28 or 29 days!");
        }
    }
}
