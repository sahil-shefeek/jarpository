import java.util.Scanner;
import java.lang.Math;

public class quadraticEqn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        System.out.println("Enter the coeffecient of x^2 :");
        a = scanner.nextDouble();
        System.out.println("Enter the coeffecient of x :");
        b = scanner.nextDouble();
        System.out.println("Enter the constant term :");
        c = scanner.nextDouble();
        double discriminant = (b * b) - (4 * a * c);
        double D = Math.sqrt(discriminant) / (2 * a);
        double coeff = (-b) / (2 * a);
        if (discriminant == 0)
            System.out.printf("The roots are real and equal!\nx = %f\n", coeff);
        else if (discriminant > 0) {
            double x1 = coeff + D;
            double x2 = coeff - D;
            System.out.printf("The roots are :\nx1 = %f\nx2 = %f\n", x1, x2);
        } else {
            D = (Math.sqrt((4 * a * c) - (b * b))) / (2 * a);
            System.out.printf("The roots are imaginary :\nx1 = %f + i%f\nx2 = %f - i%f\n", coeff, D, coeff, D);
        }
    }
}
