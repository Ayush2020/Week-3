public class FirstAndLastOccurence {
    public static int findFirstOccurence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirstOccurence(arr, target);
        int last = findLastOccurence(arr, target);

        return new int[]{first, last};

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int[] result = findFirstAndLast(arr, target);

        if (result[0] == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("First Occurrence: " + result[0]);
            System.out.println("Last Occurence: " + result[1]);
        }
    }
}
