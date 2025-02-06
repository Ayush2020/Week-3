import java.util.Arrays;

public class SearchChallenge {

    // Linear Search to find the first missing positive integer
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        // Mark elements (negative marking)
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                arr[i] = n + 1; // Mark negative or zero values as larger than any valid number
            }
        }

        // Use the elements' value as index for marking
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                arr[val - 1] = -Math.abs(arr[val - 1]); // Mark the element by making it negative
            }
        }

        // Find the first index with a positive value
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;  // Return the first missing positive integer
            }
        }

        return n + 1;  // If all values from 1 to n are present, return n + 1
    }

    // Binary Search to find the index of the target in a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found, return index
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search the right half
            } else {
                right = mid - 1;  // Search the left half
            }
        }

        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 10, 8, 5};

        // 1. Finding the first missing positive integer using Linear Search
        int missingPositive = firstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missingPositive);

        // 2. Binary Search for target index
        Arrays.sort(arr);  // Sort the array for Binary Search
        int target = 5;
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
