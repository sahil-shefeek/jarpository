import java.util.Scanner;
import java.lang.Math;

public class ArmstrongNumber {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number :");
        int num = scanner.nextInt();
        int temp = num;
        int sum = 0, digit;
        while (temp != 0) {
            digit = temp % 10;
            sum += (int) Math.pow(digit, 3.0);
            temp /= 10;
        }
        if (sum == num)
            System.out.printf("%d is armstrong.\n", sum);
        else
            System.out.printf("%d is not armstrong.\n", num);
    }
}
