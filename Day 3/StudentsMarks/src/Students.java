import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        float[] markList = initMarkList();
        int count = countStudentPassed(markList);
        System.out.println("The number of students that passed the exam is " + count);
    }

    public static float[] initMarkList(){
        Scanner sc = new Scanner(System.in);
        int numberOfStudents;
        do {
            System.out.print("Enter numbers of students (>0 and <30): ");
            numberOfStudents = sc.nextInt();
        } while (numberOfStudents < 0 || numberOfStudents > 30);
        float[] markList = new float[numberOfStudents];
        for (int i = 0; i < markList.length; i++) {
            System.out.print("Enter mark of the student " + (i+1) + ": ");
            markList[i] = sc.nextFloat();
        }
        return markList;
    }

    public static int countStudentPassed(float[] array) {
        int count = 0;
        for (float element : array) {
            count = (element > 5)? count + 1 : count;
        }
        return count;
    }

}
