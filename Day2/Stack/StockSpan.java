
import java.util.Stack;

public class StockSpan {

    // Function to calculate stock span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the stock prices array
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, it means the price is greater than all previous prices
            if (stack.isEmpty()) {
                span[i] = i + 1;  // The span is the current index + 1
            } else {
                
                span[i] = i - stack.peek();
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.println("Stock prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        System.out.println("\nStock spans: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
