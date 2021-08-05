import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weight: ");
        float weight = sc.nextFloat();
        System.out.println("Enter height: ");
        float height = sc.nextFloat();

        float bmi = calculateBMI(weight, height);
        String result;

        System.out.println("BMI: " + bmi);
        if (bmi >= 30) {
            result = "Obese";
        } else if (bmi >= 25) {
            result = "Overweight";
        } else if (bmi >= 18.5) {
            result = "Normal";
        } else {
            result = "Underweight";
        }
        System.out.println("Interpretation: " + result);
    }

    public static float calculateBMI(float weight, float height) {
        return weight / (height * height);
    }
}
