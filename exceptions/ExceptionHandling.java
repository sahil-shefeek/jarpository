import java.util.Scanner;

public class ExceptionHandling {

    public static void process(int number) throws ArithmeticException {
        if (number == 0) {
            throw new ArithmeticException();
        }
        int result = 10 / number;
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int userInput = scanner.nextInt();
            process(userInput);

        } catch (ArithmeticException e) {
            System.err.println("Exception caught: Cannot divide by zero!");

        } finally {
            System.out.println("Finally block executed.");
            scanner.close();
        }
    }
}
