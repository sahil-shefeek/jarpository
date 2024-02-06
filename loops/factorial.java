import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number :");
        int num = scanner.nextInt();
        int factorial = 1;
        int temp = num;
        while (temp != 0) {
            factorial = factorial * temp;
            temp--;
        }
        System.out.println("The factorial of " + num + " is " + factorial);
    }
}
