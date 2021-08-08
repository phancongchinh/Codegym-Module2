import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int choice = -1;
        float   [][] matrix   = initMatrix();
        int     theColumn     = getTheColumn();
        float   sum           = columnSumUp(matrix, theColumn);
        System.out.println("Sum of the column " + theColumn + " of the matrix is " + sum);
    }
    public static float[][] initMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        float[][] matrix = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element ["+i+"]["+j+"]: ");
                matrix[i][j] = sc.nextFloat();
            }
        }
        return matrix;
    }
    public static int getTheColumn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the column that needs to be summed up: ");
        return sc.nextInt();
    }
    public static float columnSumUp(float[][] matrix, int column){
        float sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][column];
        }
        return sum;
    }
}
