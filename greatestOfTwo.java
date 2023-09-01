import java.util.Scanner;

public class greatestOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("System.in");
        System.out.println("Enter two numbers :");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a > b)
            System.out.println(a + " is greater than " + b);
        else
            System.out.println(b + " is greater than " + a);
    }

}
