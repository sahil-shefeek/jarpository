import java.util.Scanner;
import java.lang.Math;

public class MethodOverloading {

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static double calculateArea(float base, float height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape to calculate its area:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                System.out.println("Area of the circle: " + calculateArea(radius));
                break;
            case 2:
                System.out.print("Enter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = scanner.nextDouble();
                System.out.println("Area of the rectangle: " + calculateArea(length, width));
                break;
            case 3:
                System.out.print("Enter the base of the triangle: ");
                float base = scanner.nextFloat();
                System.out.print("Enter the height of the triangle: ");
                float height = scanner.nextFloat();
                System.out.println("Area of the triangle: " + calculateArea(base, height));
                break;
            default:
                System.out.println("Invalid choice!");
        }

    }
}
