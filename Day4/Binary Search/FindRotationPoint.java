public class FindRotationPoint {

    // Method to find the rotation point (smallest element) in a rotated sorted array
    public static int findRotationPoint(int[] arr) {
        // Initialize two pointers: left and right
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search to find the rotation point
        while (left < right) {
            // Calculate the middle index
            int mid = (left + right) / 2;

            // Check if the middle element is greater than the next element
            // If so, the smallest element (rotation point) must be in the right half of the array
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;  // Move the left pointer to the right half
            } else {
                // Otherwise, the smallest element must be in the left half (including mid)
                right = mid;  // Move the right pointer to mid
            }
        }

        // After the loop ends, left will be equal to right, pointing to the rotation point
        return arr[left];  // The smallest element (rotation point) is at the left (or right) index
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = {10, 2, 3, 4, 5, 6, 7, 8, 9};

        // Find the rotation point (smallest element)
        int rotationPoint = findRotationPoint(arr);

        // Print the rotation point (smallest element)
        System.out.println(rotationPoint);
    }
}
