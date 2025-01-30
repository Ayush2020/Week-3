import java.util.HashMap;

public class TwoSum {

    // Method to find two indices that add up to the target sum
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the value and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement

            // If complement exists in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // Return indices as an array
            }

            // Otherwise, store the current number and its index in the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (or could throw an exception)
        throw new IllegalArgumentException("No solution found");
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        // Call the twoSum method
        int[] result = twoSum(nums, target);

        // Output the result
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
