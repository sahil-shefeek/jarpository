import java.util.Scanner;

public class DescendingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the limit :");
        int num = scanner.nextInt();
        int i = num;
        while (i > 0) {
            System.out.println(i);
            i--;
        }
    }
}
