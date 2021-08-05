import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        System.out.printf(
                "Area = %.2f", getArea()
        );
        calculateAnother();
    }

    public static float getArea () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width: ");
        float width = sc.nextFloat();
        System.out.print("Enter height: ");
        float height = sc.nextFloat();
        return width * height;
    }

    public static void calculateAnother() {
        System.out.println("");
        System.out.println("Calculate area for another rectangle? Q to Quit, others to calculate another!");
        Scanner sc = new Scanner(System.in);
        char response = sc.next().charAt(0);
        switch (response) {
            case 'q':
            case 'Q':
                return;
            default:
                System.out.printf(
                        "Area = %.2f", getArea()
                );
        }
    }
}
