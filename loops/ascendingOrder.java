import java.util.Scanner;

public class ascendingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the limit :");
        int num = scanner.nextInt();
        int i = 0;
        while (i < num) {
            System.out.println(i + 1);
            i++;
        }
    }
}
