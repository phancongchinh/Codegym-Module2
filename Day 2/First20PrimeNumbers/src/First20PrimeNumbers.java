import java.util.Scanner;

public class First20PrimeNumbers {
    public static void main(String[] args) {
        int count = 1;
        int num = 0;
        while (count <= 20) {
            if (isPrime(num)) {
                System.out.println("Prime " + count + ": " + num);
                count++;
                num++;
            }
            num++;
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
