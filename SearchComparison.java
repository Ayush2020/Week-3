package com.tit;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Binary Search (O(log N))
    public static int binarySearch(int[] arr, int target) {
        return Arrays.binarySearch(arr, target); // Returns index if found, else negative value
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] dataset = new int[size];

            // Fill dataset with random numbers
            for (int i = 0; i < size; i++) {
                dataset[i] = random.nextInt(size * 10); // Range [0, size*10]
            }

            // Pick a random target
            int target = dataset[random.nextInt(size)];

            // Measure Linear Search Time
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long linearTime = System.nanoTime() - startTime;

            // Sort for Binary Search
            Arrays.sort(dataset); // O(N log N)

            // Measure Binary Search Time
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            long binaryTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (linearTime));
            System.out.println("Binary Search Time: " + (binaryTime));
            System.out.println();
        }
    }
}