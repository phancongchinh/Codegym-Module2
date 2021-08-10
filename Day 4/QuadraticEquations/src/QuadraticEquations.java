import java.util.Scanner;

public class QuadraticEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        QuadraticEquations equation1 = new QuadraticEquations(a,b,c);
        double delta = equation1.getDiscriminant();
        if (delta < 0) {
            System.out.println("The equation has no root!");
        } else if (delta == 0){
            System.out.println("The equation has one root: " + equation1.getRoot1());
        } else {
            System.out.println("The equation has two roots :" + equation1.getRoot1() + " and " + equation1.getRoot2());
        }
    }

    double a, b, c;

    public QuadraticEquations(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        return (this.getDiscriminant() > 0) ? (-b + Math.sqrt(this.getDiscriminant())) / (2 * a) : 0;
    }

    public double getRoot2() {
        return (this.getDiscriminant() > 0) ? (-b - Math.sqrt(this.getDiscriminant())) / (2 * a) : 0;
    }
}
