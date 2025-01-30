import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the two stacks
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation - push an element into stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation - remove an element from the front of the queue
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is empty, then the queue is empty
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // Pop the element from stack2 (this is the front of the queue)
        return stack2.pop();
    }

    // Peek operation - get the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is empty, then the queue is empty
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // Return the element from the front of the queue
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class StackQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue and print the front element
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek());    // Output: 2
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.isEmpty()); // Output: true
    }
}
