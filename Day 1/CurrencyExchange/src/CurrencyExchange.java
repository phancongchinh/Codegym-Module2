import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int ratio = 23500;
        System.out.print("Enter the amount of USD: ");
        int usd = sc.nextInt();
        System.out.println("$" + usd + " is equivalent to VND" + usd * ratio);
    }
}
