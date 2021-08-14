import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter radius of a circle: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println(circle);
        System.out.println("Its area: " + circle.getArea());

        System.out.print("\nEnter height of a cylinder which has the above circle as its base: ");
        double height = scanner.nextDouble();
        Cylinder cylinder = new Cylinder(radius,height);
        System.out.println(cylinder);
        System.out.println("Its volume: " + cylinder.getVolume());
    }
}
