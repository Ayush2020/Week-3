public class MatrixBinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;  // Handle empty matrix
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;  // Treat the matrix as a 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Find the middle element index

            // Convert the mid index to row and column
            int row = mid / columns;
            int col = mid % columns;

            // Compare the middle element with the target
            if (matrix[row][col] == target) {
                return true;  // Found the target
            } else if (matrix[row][col] < target) {
                left = mid + 1;  // Search the right half
            } else {
                right = mid - 1;  // Search the left half
            }
        }

        return false;  // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target = 11;

        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
