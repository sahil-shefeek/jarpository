import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int element, size;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the element to search : ");
        element = scanner.nextInt();
        System.out.println("Enter the array elements :\n");

        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                System.out.printf("Found %d at index %d\n", element, i);
                System.exit(0);
            }
        }
        System.out.printf("The entered element %d was not found in the given array.\n");
    }
}
