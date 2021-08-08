import java.util.Scanner;

public class MatrixDiagonal {
    public static void main(String[] args) {
        int     size    = getSize();
        int[][] matrix  = initMatrix(size);
        int     sum     = diagonalSumUp(matrix);
        System.out.println("The diagonal sum is: " + sum);
    }

    public static int getSize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        return sc.nextInt();
    }

    public static int[][] initMatrix(int size){
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[size][size];
        System.out.println("Enter elements: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Element ["+i+"]["+j+"]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int diagonalSumUp(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
