import java.util.Scanner;

public class MaxValueInMatrix {
    public static void main(String[] args) {
        int[][] matrix = initMatrix();
        System.out.println("The maximum value in the matrix is: " + findMaxValue(matrix));
        System.out.println("It's located at the coordinate(s): " + findCoordinate(findMaxValue(matrix), matrix));
    }

    public static int[][] initMatrix () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of cols: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element at coordinate [" + i +"][" + j +"]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int findMaxValue(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] rows : matrix) {
            for (int element : rows) {
                max = Math.max(element, max);
            }
        }
        return max;
    }

    public static String findCoordinate(int value, int[][] matrix) {
        String coordinate = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == value) {
                    coordinate += "[i][j]";
                }
            }
        }
        return coordinate;
    }
}
