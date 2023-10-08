import java.util.Scanner;

public class transpose {
    public static void main(String[] args) {
        int rows, cols;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of matrix:\n");

        rows = scanner.nextInt();
        cols = scanner.nextInt();

        int mat[][] = new int[rows][cols];
        int trans[][] = new int[cols][rows];
        System.out.println("Enter the elements of matrix:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                mat[i][j] = scanner.nextInt();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                trans[j][i] = mat[i][j];
        }
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++)
                System.out.printf("%d ", trans[i][j]);
            System.out.println();
        }
    }
}
