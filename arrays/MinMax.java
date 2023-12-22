import java.util.*;

class MinMax {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[15], i = 0;
        System.out.print("Enter size of array:\n");
        int n = scanner.nextInt();
        System.out.print("Enter elements of array:\n");
        for (i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.print("Array is:");
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        int smallest = a[0];
        int largest = a[0];
        for (i = 1; i < n; i++) {
            if (a[i] > largest) {
                largest = a[i];
            } else if (a[i] < smallest) {
                smallest = a[i];
            }
        }
        System.out.println("\nLargest element is: " + largest);
        System.out.println("\nSmallest element is: " + smallest);
    }
}
