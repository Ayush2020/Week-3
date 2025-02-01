import java.util.Arrays;

public class QuickSort {

    // Function to implement quick sort
    public static void quickSort(int[] productPrices, int low, int high) {
        if (low < high) {
            // Find the pivot index after partitioning
            int pivotIndex = partition(productPrices, low, high);

            // Recursively sort the left and right partitions
            quickSort(productPrices, low, pivotIndex - 1);
            quickSort(productPrices, pivotIndex + 1, high);
        }
    }


    private static int partition(int[] productPrices, int low, int high) {
        int pivot = productPrices[high];
        int i = low - 1;


        for (int j = low; j < high; j++) {

            if (productPrices[j] <= pivot) {
                i++;

                int temp = productPrices[i];
                productPrices[i] = productPrices[j];
                productPrices[j] = temp;
            }
        }


        int temp = productPrices[i + 1];
        productPrices[i + 1] = productPrices[high];
        productPrices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] productPrices = {499, 299, 899, 199, 399, 799, 599, 129};


        quickSort(productPrices, 0 , productPrices.length-1);
        System.out.println(Arrays.toString(productPrices));
    }
}
