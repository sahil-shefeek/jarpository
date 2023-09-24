import java.util.Scanner;

public class prime_number {

    static boolean is_prime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter range:");
        System.out.println("Start from :");
        int low = scanner.nextInt();
        System.out.println("End at :");
        int high = scanner.nextInt();
        System.out.printf("The prime numbers between %d and %d are : \n", low, high);

        for (int i = low; i <= high; i++) {
            if (is_prime(i))
                System.out.println(i);
        }
    }
}