import java.util.Scanner;

public class bubble_sort {
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int lim = scanner.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[lim + 1];
        for (int i = 0; i < lim; i++)
            arr[i] = scanner.nextInt();
        System.out.println("You entered:");
        printArray(arr, lim);

        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < lim - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.println("Sorting...");
        printArray(arr, lim);

    }
}
