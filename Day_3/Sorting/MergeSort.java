import java.util.Arrays;

public class MergeSort {

    // Function to implement merge sort
    public static void mergeSort(int[] bookPrices) {
        if (bookPrices.length <= 1) {
            return;  // Base case: array is already sorted
        }

        // Find the middle point
        int middle = bookPrices.length / 2;

        // Split the array into two halves
        int[] left = Arrays.copyOfRange(bookPrices, 0, middle);
        int[] right = Arrays.copyOfRange(bookPrices, middle, bookPrices.length);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(bookPrices, left, right);
    }

    // Merge two sorted arrays into a single sorted array
    private static void merge(int[] bookPrices, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Compare and merge the arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                bookPrices[k++] = left[i++];
            } else {
                bookPrices[k++] = right[j++];
            }
        }

        while (i < left.length) {
            bookPrices[k++] = left[i++];
        }

       
        while (j < right.length) {
            bookPrices[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        // Example array of book prices
        int[] bookPrices = {150, 200, 50, 300, 100, 250, 120, 180};

       
        mergeSort(bookPrices);

        System.out.println(Arrays.toString(bookPrices));
    }
}
