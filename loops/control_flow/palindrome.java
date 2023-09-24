import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp, digit, rev = 0;
        System.out.println("Enter any number :");
        int num = scanner.nextInt();
        temp = num;
        while (temp != 0) {
            digit = temp % 10;
            rev = rev * 10 + digit;
            temp /= 10;
        }

        if (num == rev)
            System.out.println(num + " is palindome.");
        else
            System.out.println(num + " is not palindome.");
    }
}
