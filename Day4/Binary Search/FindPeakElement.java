public class FindPeakElement {

    // Method to find a peak element in an array using binary search
    public static int findPeakElement(int[] arr) {
        // Initialize left and right pointers to the start and end of the array
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search to find a peak element
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // Check if arr[mid] is a peak element
            // A peak element is greater than its neighbors (arr[mid-1] and arr[mid+1])
            // Special handling for boundary elements (when mid is 0 or mid is at the last index)
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                // If mid is a peak, return the peak element
                return arr[mid];
            }
            // If the element at mid is less than the element to the left (arr[mid-1]),
            // then the peak must lie on the left side of the array
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                // Move the right pointer to the left half of the array
                right = mid - 1;
            }
            // If the element at mid is less than the element to the right (arr[mid+1]),
            // then the peak must lie on the right side of the array
            else {
                // Move the left pointer to the right half of the array
                left = mid + 1;
            }
        }

        // If no peak is found (though it should always find one in a non-empty array)
        return -1;
    }

    public static void main(String[] args) {
        // Example array where we will search for a peak element
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Find the peak element in the array
        int peak = findPeakElement(arr);

        // Output the found peak element
        System.out.println(peak);
    }
}
