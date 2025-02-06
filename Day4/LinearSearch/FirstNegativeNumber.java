public class FirstNegativeNumber {

    // Function to find the first negative number
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is negative
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        // If no negative number is found, return -1
        return -1;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test arrays
        int[] arr1 = {1, 3, 5, -2, 4, 6};
        int[] arr2 = {2, 3, 4, 5, 6};
        int[] arr3 = {-1, 2, 3, 4};

        // Running test cases
        System.out.println(findFirstNegative(arr1));  
        System.out.println(findFirstNegative(arr2));  
        System.out.println(findFirstNegative(arr3));  
    }
}
