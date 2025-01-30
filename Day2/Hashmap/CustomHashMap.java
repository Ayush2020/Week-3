import java.util.*;

public class CustomHashMap {

    // Define the initial capacity of the hash map
    private static final int INITIAL_CAPACITY = 16;

    // Array of linked lists (buckets)
    private LinkedList<Node>[] table;

    // Constructor to initialize the hash map
    public CustomHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Node class to store the key-value pairs
    private static class Node {
        String key;
        String value;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to calculate index for a given key
    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    // Insert or update the key-value pair
    public void put(String key, String value) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = table[index];

        // Check if key already exists in the bucket
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;  // Update the value
                return;
            }
        }

        // If the key doesn't exist, add a new node with key and value
        bucket.add(new Node(key, value));
    }

    // Retrieve the value associated with a key
    public String get(String key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = table[index];

        // Search through the bucket to find the key and return its value
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;  // If key doesn't exist, return null
    }

    // Remove the key-value pair associated with the key
    public void remove(String key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = table[index];

        // Search for the key and remove the corresponding node
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Check if a key exists in the hash map
    public boolean containsKey(String key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = table[index];

        // Search for the key in the bucket
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }

        return false;  // If key doesn't exist, return false
    }

    // Main method for testing the CustomHashMap
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        // Insert key-value pairs
        map.put("name", "Gautam");
        map.put("age", "22");
        map.put("city", "Bhopal");

        // Retrieve values
        System.out.println("name: " + map.get("name"));
        System.out.println("age: " + map.get("age"));
        System.out.println("city: " + map.get("city"));

        // Check if a key exists
        System.out.println("Contains 'age': " + map.containsKey("age"));
        System.out.println("Contains 'country': " + map.containsKey("country"));

        // Remove a key-value pair
        map.remove("age");

        // Try retrieving the removed key
        System.out.println("age after removal: " + map.get("age"));  // Output: null
    }
}
