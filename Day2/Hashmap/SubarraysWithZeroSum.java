import java.util.*;

public class SubarraysWithZeroSum {

    // Function to find all subarrays with zero sum
    public static List<List<Integer>> findSubarraysWithZeroSum(int[] arr) {
        // List to store all subarrays with zero sum
        List<List<Integer>> result = new ArrayList<>();

        // HashMap to store the cumulative sum and the list of indices where it occurs
        Map<Integer, List<Integer>> cumulativeSumMap = new HashMap<>();

        // Variable to store the cumulative sum
        int cumulativeSum = 0;

        // Add the cumulative sum 0 to handle cases where the subarray starts from index 0
        cumulativeSumMap.put(0, new ArrayList<>());
        cumulativeSumMap.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If the cumulative sum has been seen before, then there are zero-sum subarrays
            if (cumulativeSumMap.containsKey(cumulativeSum)) {
                // Get the indices of the previous occurrences of this cumulative sum
                List<Integer> indices = cumulativeSumMap.get(cumulativeSum);

                // For each of these indices, there exists a subarray with zero sum
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    // Add the subarray elements from index+1 to i
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }

            // Add the current index to the list of indices for the cumulative sum
            cumulativeSumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            cumulativeSumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, 3, -3, 4, -2, 2, 2, -4};

        List<List<Integer>> subarrays = findSubarraysWithZeroSum(arr);

        // Print all subarrays with zero sum
        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
