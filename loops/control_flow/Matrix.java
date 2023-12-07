import java.util.Scanner;

class Matrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[15][15];
        int b[][] = new int[15][15];
        int c[][] = new int[15][15];
        int choice, r1, c1, r2, c2;

        System.out.println("***MENU***\n1) Addition\n2) Multiplication\n3) Transpose\n4)Quit");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter rows and columns of first matrix:");
                r1 = sc.nextInt();
                c1 = sc.nextInt();

                System.out.println("Enter elements of first matrix:");
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c1; j++) {
                        a[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Enter rows and columns of second matrix:");
                r2 = sc.nextInt();
                c2 = sc.nextInt();
                System.out.println("Enter elements of second matrix:");
                for (int i = 0; i < r2; i++) {
                    for (int j = 0; j < c2; j++) {
                        b[i][j] = sc.nextInt();
                    }
                }
                // addition
                if (r1 == c1 && r2 == c2) {
                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c1; j++) {
                            c[i][j] = a[i][j] + b[i][j];
                        }
                    }
                    System.out.println("Sum matrix is:");
                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c1; j++) {
                            System.out.printf("%d\t", c[i][j]);
                        }
                        System.out.println();
                    }
                } else {
                    System.out.print("Addition not possible\n");
                }
                break;

            case 2:
                System.out.println("Enter rows and columns of first matrix:");
                r1 = sc.nextInt();
                c1 = sc.nextInt();

                System.out.println("Enter elements of first matrix:");
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c1; j++) {
                        a[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Enter rows and columns of second matrix:");
                r2 = sc.nextInt();
                c2 = sc.nextInt();
                System.out.println("Enter elements of second matrix:");
                for (int i = 0; i < r2; i++) {
                    for (int j = 0; j < c2; j++) {
                        b[i][j] = sc.nextInt();
                    }
                }
                // multiplication
                if (r2 == c1) {
                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c2; j++) {
                            c[i][j] = 0;
                            for (int k = 0; k < c1; k++)
                                c[i][j] += a[i][k] * b[k][j];
                        }
                    }
                    System.out.print("Product matrix is:\n");
                    for (int i = 0; i < r2; i++) {
                        for (int j = 0; j < c1; j++) {
                            System.out.print(c[i][j] + " ");
                        }
                        System.out.print("\n");
                    }

                } else {
                    System.out.print("Multiplication not possible\n");
                }
                break;

            case 3:
                System.out.println("Enter rows and columns of matrix:");
                r1 = sc.nextInt();
                c1 = sc.nextInt();
                System.out.println("Enter matrix elements:");
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c1; j++) {
                        a[i][j] = sc.nextInt();
                    }
                }
                // transpose
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c1; j++) {
                        c[i][j] = a[j][i];
                    }
                }
                System.out.println("Transpose of matrix A is:");
                for (int i = 0; i < c1; i++) {
                    for (int j = 0; j < r1; j++) {
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.print("\n");
                }
                break;

            case 4:
                System.out.println("Program terminated");
                break;
        }

    }
}
