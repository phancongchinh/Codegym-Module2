import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static double side1, side2, side3;

    public static void main(String[] args) {
        System.out.println("Enter side's length and colour of a triangle!");

        requestSides();

        while (!isTriangleInequalitySatisfied(side1,side2,side3)) {
            System.out.println("Make sure that the triangle inequality is satisfied!");
            requestSides();
        }

        scanner.nextLine();

        Shape triangle = new Triangle(side1,side2,side3);

        System.out.print("Enter colour: ");
        String colour = scanner.nextLine();

        triangle.setColour(colour);

        System.out.println(triangle);

    }

    public static boolean isTriangleInequalitySatisfied(double side1, double side2, double side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }

    public static void requestSides(){
        System.out.print("Side 1: ");
        side1 = scanner.nextDouble();
        System.out.print("Side 2: ");
        side2 = scanner.nextDouble();
        System.out.print("Side 3: ");
        side3 = scanner.nextDouble();
    }

}
