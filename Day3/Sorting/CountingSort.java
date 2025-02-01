import java.util.Arrays;

public class CountingSort {

    // Function to implement counting sort for ages
    public static void countingSort(int[] ages) {
        int maxAge = 18;  // Maximum age in the given range
        int minAge = 10;  // Minimum age in the given range
        int range = maxAge - minAge + 1;

        // Create a count array to store frequency of each age
        int[] count = new int[range];

        // Count the frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Modify the count array to store the cumulative sum
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Create the output array to store the sorted ages
        int[] output = new int[ages.length];

        // Place the ages in their correct positions in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy the sorted output array back to the original ages array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        // Example array of student ages
        int[] studentAges = {15, 10, 17, 12, 18, 16, 15, 13, 14};

        
        countingSort(studentAges);

        // Print the sorted array
        System.out.println(Arrays.toString(studentAges));
    }
}
