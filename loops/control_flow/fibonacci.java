import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of terms :");
        int lim = scanner.nextInt();
        int a = 0, b = 1, c;
        System.out.printf("Fibonacci series upto %d terms is :\n", lim);
        if (lim > 0) {
            System.out.println(a);
            if (lim > 1)
                System.out.println(b);
        }
        for (int i = 2; i < lim; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}
