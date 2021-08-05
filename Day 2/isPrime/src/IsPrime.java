import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number!");
        int number = sc.nextInt();
        if (isPrime(number)) {
            System.out.println(number + " is a prime number!");
        } else {
            System.out.println(number + " is NOT a prime number!");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
