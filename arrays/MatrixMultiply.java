import java.util.Scanner;

public class MatrixMultiply {
    public static void main(String[] args) {
        int aRows, aCols, bRows, bCols;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t~~~ Matrix multiplication ~~~\n");
        System.out.println("Enter details of first matrix:");
        System.out.println("Enter the number of rows:");
        aRows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        aCols = scanner.nextInt();
        System.out.println("\t******");
        System.out.println("\nEnter details of second matrix:");
        System.out.println("Enter the number of rows:");
        bRows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        bCols = scanner.nextInt();
        System.out.println("\t******");
        if (aCols == bRows) {
            int[][] a = new int[aRows][aCols];
            int[][] b = new int[bRows][bCols];
            int[][] res = new int[aCols][bRows];

            System.out.println("\nEnter the elements of first matrix:");
            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < aCols; j++)
                    a[i][j] = scanner.nextInt();
            }

            System.out.println("You entered:");
            for (int i = 0; i < bRows; i++) {
                for (int j = 0; j < bCols; j++)
                    System.out.printf("%d\t", a[i][j]);
                System.out.println();
            }

            System.out.println("\nEnter the elements of second matrix:");
            for (int i = 0; i < bRows; i++) {
                for (int j = 0; j < bCols; j++)
                    b[i][j] = scanner.nextInt();
            }

            System.out.println("You entered:");
            for (int i = 0; i < bRows; i++) {
                for (int j = 0; j < bCols; j++)
                    System.out.printf("%d\t", b[i][j]);
                System.out.println();
            }

            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < bCols; j++) {
                    for (int k = 0; k < bRows; k++) {
                        res[i][j] += a[k][j] * b[i][k];
                    }
                }
            }

            System.out.println("\nProduct is:");
            for (int i = 0; i < bRows; i++) {
                for (int j = 0; j < bCols; j++)
                    System.out.printf("%d\t", res[i][j]);
                System.out.println();
            }
        } else
            System.out.println("Matrix Multiplication is not possible!");
    }
}