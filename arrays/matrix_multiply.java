import java.util.Scanner;

public class matrix_multiply {
    public static void main(String[] args) {
        int aRows, aCols, bRows, bCols;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of columns and rows of first matrix:");
        aRows = scanner.nextInt();
        aCols = scanner.nextInt();
        System.out.println("Enter the number of columns and rows of second matrix:");
        bRows = scanner.nextInt();
        bCols = scanner.nextInt();
        if (aCols == bRows) {
            int[][] a = new int[aRows][aCols];
            int[][] b = new int[bRows][bCols];
            int[][] res = new int[aCols][bRows];
            System.out.println("Enter the elements of first matrix:");
            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < aCols; j++)
                    a[i][j] = scanner.nextInt();
            }
            System.out.println("Enter the elements of second matrix:");
            for (int i = 0; i < bRows; i++) {
                for (int j = 0; j < bCols; j++)
                    b[i][j] = scanner.nextInt();
            }

            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < aCols; j++) {
                    for (int k = 0; k < aCols; k++) {
                        res[i][k] += a[i][k] * b[k][i];
                    }
                }
            }
        }
    }
}
