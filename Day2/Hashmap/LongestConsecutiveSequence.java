import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Create a HashSet to store unique elements
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through the array
        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Extend the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak if necessary
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));  // Output: 4 (The sequence is 1, 2, 3, 4)
    }
}
