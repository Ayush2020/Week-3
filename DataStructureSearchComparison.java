import java.util.*;

public class DataStructureSearchComparison {

    // Array Search (Linear Search)
    public static boolean searchArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // HashSet Search (Constant Time Search)
    public static boolean searchHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // TreeSet Search (Logarithmic Time Search)
    public static boolean searchTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
        // Test with different dataset sizes (1,000; 100,000; 1,000,000)
        int[] testSizes = {1000, 100000, 1000000};

        for (int size : testSizes) {
            System.out.println("Dataset size: " + size);

            // Create dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            // Random target for search
            int target = size / 2;

            // Measure Array Search time
            long startTime = System.nanoTime();
            searchArray(array, target);
            long endTime = System.nanoTime();
            System.out.println("Array Search Time: " + (endTime - startTime) / 1_000_000 + "ms");

            // Measure HashSet Search time
            startTime = System.nanoTime();
            searchHashSet(hashSet, target);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1_000_000 + "ms");

            // Measure TreeSet Search time
            startTime = System.nanoTime();
            searchTreeSet(treeSet, target);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1_000_000 + "ms");

            System.out.println();
        }
    }
}
