import java.util.Scanner;

public class is_Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scanner.nextInt();
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.printf("%d is not prime.\n", num);
                System.exit(0);
            }
        }
        System.out.printf("%d is prime.\n", num);
    }
}
