import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        int rows, cols;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of matrix:\n");
        rows = scanner.nextInt();
        cols = scanner.nextInt();

        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        System.out.println("Enter the elements of 1st matrix:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                mat1[i][j] = scanner.nextInt();
        }
        System.out.println("Enter the elements of 2nd matrix:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                mat2[i][j] = scanner.nextInt();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                sum[i][j] = mat1[i][j] + mat2[i][j];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.printf("%d ", sum[i][j]);
            System.out.println();
        }
    }
}
