import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] testArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < testArray.length; i++)
            testArray[i] = random.nextInt(10000); //Generates a random number to test the sort fn
        System.out.println("Original array:");
        printArray(testArray);
        MergeSortArray(testArray);
        System.out.println("Sorted array:");
        printArray(testArray);
    }

    public static void MergeSortArray(int[] inputArray) {
        int inputLength = inputArray.length;
        if (inputLength < 2) 
            return;
        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex];
        for (int i = 0; i < midIndex; i++)
            leftHalf[i] = inputArray[i];
        int[] rightHalf = new int[inputLength - midIndex];
        for (int i = midIndex; i < inputLength; i++)
            rightHalf[i - midIndex] = inputArray[i];
        MergeSortArray(leftHalf);
        MergeSortArray(rightHalf);
        MergeArray(inputArray, leftHalf, rightHalf);
    } 

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
    }
    private static void MergeArray(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
