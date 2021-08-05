import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of money (VND): ");
        int money = sc.nextInt();
        System.out.print("Enter the interest rate (% over a year): ");
        float interestRate = sc.nextFloat();
        System.out.print("How many months that you have to pay the interest back!");
        int month = sc.nextInt();
        float interest = money * (interestRate / 100) * month / 12;
        System.out.println("The interest is: " + interest);
    }
}
