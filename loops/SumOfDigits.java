import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp, digit, sum = 0;
        System.out.println("Enter any number :");
        int num = scanner.nextInt();
        temp = num;
        while (temp != 0) {
            digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        System.out.println("The sum of digits of " + num + " is " + sum);
    }
}
