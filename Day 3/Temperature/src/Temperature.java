import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            drawMenu();
            switch (getChoice()) {
                case 1:
                    fahrenheitToCelsius();
                    break;
                case 2:
                    celsiusToFahrenheit();
                    break;
                case 0:
                    System.exit(0);
                default:
                    getChoice();
            }
        }
    }

    public static void drawMenu() {
        System.out.println("Menu:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("0. Exit!");
    }

    public static int getChoice() {
        System.out.print("Please make your choice: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void fahrenheitToCelsius() {
        System.out.println("Enter temperature in Fahrenheit: ");
        Scanner sc = new Scanner(System.in);
        double fahrenheit = sc.nextDouble();
        System.out.println("It's equivalent to " + (5 / 9) * (fahrenheit - 32.0) + " in Celsius!");
    }

    public static void celsiusToFahrenheit() {
        System.out.println("Enter temperature in Celsius: ");
        Scanner sc = new Scanner(System.in);
        double celsius = sc.nextDouble();
        System.out.println("It's equivalent to " + (celsius * 9 / 5 + 32.0) + " in Fahrenheit!");
    }
}
