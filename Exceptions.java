import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int a = scanner.nextInt();
            System.out.print("Enter a number: ");
            int b = scanner.nextInt();
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ERROR: Division by zero!");
        } finally {
            System.out.println("Finally block executed");
            scanner.close();
        }
    }
}
