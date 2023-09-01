import java.util.Scanner;

public class largestOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers :");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b) {
            if (a > c)
                System.out.println(a + " is largest\n");
            else
                System.out.println(c + " is largest\n");
        } else {
            if (b > c)
                System.out.println(b + " is largest\n");
            else
                System.out.println(c + " is largest\n");
        }
    }
}
