import java.util.Scanner;
public class FirstDegreeEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coefficient a: ");
        float a = sc.nextFloat();
        System.out.print("Enter b: ");
        float b = sc.nextFloat();

        System.out.println(solveEquation(a,b));
    }

    public static String solveEquation(float a, float b){
        if (a==0) {
            if (b==0){
                return "The equation has infinite solutions!";
            } else {
                return "The equation has no solution!";
            }
        } else {
            return "The equation has one solution: x=" + -b/a + "!";
        }
    }

}
