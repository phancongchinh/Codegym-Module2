import java.util.Scanner;

public class TriangleExceptionExample {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] sides = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter side " + (i+1) +": " );
            sides[i] = scanner.nextInt();
            try {
                if (sides[i] <= 0) throw new NegativeSideException();
            }
            catch (NegativeSideException exception) {
                System.err.println("sides["+i+"] is negative!");
            }
        }

        try {
            boolean triangleInequalitiesNotSatisfied = sides[0] + sides[1] <= sides[2] || sides[1] + sides[2] <= sides[0] || sides[0] + sides[2] <= sides[1];
            if (triangleInequalitiesNotSatisfied) throw new NotATriangle();
        }
        catch (NotATriangle exception){
            System.err.println("Triangle Inequalities Not Satisfied!");
        }

        System.out.println("Finish!");
    }
}
