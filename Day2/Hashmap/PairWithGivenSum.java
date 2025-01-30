import java.util.HashSet;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        // Create a HashSet to store the numbers we've seen so far
        HashSet<Integer> visitedNumbers = new HashSet<>();

        // Iterate through the array
        for (int num : arr) {
            // Calculate the complement (targetSum - num)
            int complement = targetSum - num;

            // If the complement is in the set, return true
            if (visitedNumbers.contains(complement)) {
                return true;
            }

            // Add the current number to the set
            visitedNumbers.add(num);
        }

        // If no pair is found, return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int targetSum = 17;

        System.out.println(hasPairWithSum(arr, targetSum));  // Output: true (10 + 7 = 17)
    }
}
