import java.util.Scanner;
public class Test {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("We need a 2D point!");
        System.out.print("Enter x: ");
        float x = scanner.nextFloat();
        System.out.print("Enter y:");
        float y = scanner.nextFloat();
        Point2D point2D = new Point2D(x,y);
        System.out.println("The 2D point was initialized!");
        System.out.println(point2D);

        System.out.println("We also need a 3D point with x,y from the point above!");
        System.out.print("Enter z: ");
        float z = scanner.nextFloat();
        Point3D point3D = new Point3D(x,y,z);
        System.out.println("The 3D point was initialized!");
        System.out.println(point3D);
    }
}
