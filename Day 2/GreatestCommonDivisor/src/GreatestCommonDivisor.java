import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        do {
            System.out.println("GCD = " + findGCD(getFirstNum(), getSecondNum()));
        } while (findAnother());
    }

    public static boolean findAnother() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wanna find GCD of another couple? (y/n)");
        char confirm = sc.next().charAt(0);
        switch (confirm) {
            case 'y':
                return true;
            case 'n':
            default:
                return false;
        }
    }

    public static int findGCD(int firstNum, int secondNum) {
        int remainder;
        do {
            remainder = firstNum % secondNum;
            firstNum = secondNum;
            secondNum = remainder;
        } while (remainder != 0);
        return firstNum;
    }

    public static int getFirstNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNum = sc.nextInt();
        while (firstNum <= 0) {
            System.out.print("Invalid number! Enter another: ");
            firstNum = sc.nextInt();
        }
        return firstNum;
    }
    public static int getSecondNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the second number: ");
        int secondNum = sc.nextInt();
        while (secondNum <= 0) {
            System.out.print("Invalid number! Enter another: ");
            secondNum = sc.nextInt();
        }
        return secondNum;
    }

}
