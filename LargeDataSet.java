package com.tit;

import java.util.*;

public class LargeDataSet {



    // Helper method to generate a random array
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);  // Numbers between 0 and 100,000
        }
        return array;
    }

    // Measure execution time for sorting an array
    public static void measureExecutionTime(String label, int[] array, String algorithm) {
        int[] arrayCopy = array.clone(); // Clone array to avoid sorting the same array multiple times
        long startTime = System.nanoTime();

        switch (algorithm) {
            case "bubbleSort":
                bubbleSort(arrayCopy);
                break;
            case "mergeSort":
                mergeSort(arrayCopy, 0, arrayCopy.length - 1);
                break;
            case "quickSort":
                quickSort(arrayCopy, 0, arrayCopy.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(label + " - " + algorithm + " took " + duration / 1_000_000 + "ms");
    }

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[] and R[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Create random arrays of different sizes
        int[] smallArray = generateRandomArray(1000);
        int[] mediumArray = generateRandomArray(10000);
        int[] largeArray = generateRandomArray(1000000);


        // Measure execution time for Merge Sort
        System.out.println("\nMerge Sort:");
        measureExecutionTime("Small Array", smallArray, "mergeSort");
        measureExecutionTime("Medium Array", mediumArray, "mergeSort");
        measureExecutionTime("Large Array", largeArray, "mergeSort");

        // Measure execution time for Quick Sort
        System.out.println("\nQuick Sort:");
        measureExecutionTime("Small Array", smallArray, "quickSort");
        measureExecutionTime("Medium Array", mediumArray, "quickSort");
        measureExecutionTime("Large Array", largeArray, "quickSort");
        // Measure execution time for Bubble Sort
        System.out.println("Bubble Sort:");
        measureExecutionTime("Small Array", smallArray, "bubbleSort");
        measureExecutionTime("Medium Array", mediumArray, "bubbleSort");
        measureExecutionTime("Large Array", largeArray, "bubbleSort");


    }
}
