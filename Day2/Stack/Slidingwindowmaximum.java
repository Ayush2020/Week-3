import java.util.*;

public class SlidingWindowMaximum {

    // Function to calculate the maximum for each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // If the input array is null, empty, or the window size is zero, return an empty array
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length; // Length of the input array
        int[] result = new int[n - k + 1]; // Array to store the maximum values for each window
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices of the elements in the window

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Remove indices that are out of the bounds of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices from the back of the deque while the element at those indices is less than or equal to the current element
            // This ensures that the deque contains elements in decreasing order (from front to back)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // Once we have processed at least k elements, the maximum is at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()]; // The element at the front of the deque is the maximum in the current window
            }
        }

        // Return the result array containing the maximums of each sliding window
        return result;
    }

    // Main function to test the Sliding Window Maximum algorithm
    public static void main(String[] args) {
        int[] nums = {1, 3, -2, 6, 8, -5, 7, 9}; // Sample array of stock prices
        int k = 3; // Window size

        // Get the result array containing the maximum of each sliding window of size k
        int[] result = maxSlidingWindow(nums, k);

        // Print the result array (Sliding Window Maximums)
        System.out.println("Sliding Window maximums: ");
        for (int num : result) {
            System.out.print(num + " "); // Output the maximum for each window
        }
    }
}
