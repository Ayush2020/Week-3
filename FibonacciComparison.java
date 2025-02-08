package com.tit;

public class FibonacciComparison {

    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }


    public static void main(String[] args) {
        // Test for different values of N
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            System.out.println("Fibonacci(" + n + ")");

            // Measure Recursive Time
            long startTime = System.nanoTime();
            try {
                System.out.println("Recursive Result: " + fibonacciRecursive(n));
            } catch (StackOverflowError e) {
                System.out.println("Recursive calculation failed for n = " + n + " (StackOverflow)");
            }
            long endTime = System.nanoTime();
            System.out.println("Recursive Time: " + (endTime - startTime) / 1000000 + "ms");

            // Measure Iterative Time
            startTime = System.nanoTime();
            System.out.println("Iterative Result: " + fibonacciIterative(n));
            endTime = System.nanoTime();
            System.out.println("Iterative Time: " + (endTime - startTime) / 1000000 + "ms");
        }
    }
}
