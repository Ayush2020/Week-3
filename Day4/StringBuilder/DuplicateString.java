import java.util.HashSet;

public class DuplicateString {
    // Method to remove duplicates from the given string
    public static String removeDuplicates(String str) {
        // Initialize a StringBuilder to store the result string
        StringBuilder sb = new StringBuilder();

        // Initialize a HashSet to track the characters we've already seen
        HashSet<Character> seen = new HashSet<>();

        // Iterate over each character in the input string
        for (int i = 0; i < str.length(); i++) {
            // Get the current character from the string
            char c = str.charAt(i);

            // If the character has not been seen before, add it to the result
            if (!seen.contains(c)) {
                // Add the character to the HashSet (mark it as seen)
                seen.add(c);

                // Append the character to the StringBuilder
                sb.append(c);
            }
        }

        // Convert StringBuilder to String and return the result
        return sb.toString();
    }

    public static void main(String[] args) {
        // Input string to test the removeDuplicates method
        String input = "java";

        // Call the method and print the result (duplicates removed)
        System.out.println(removeDuplicates(input));  // Output will be "jav"
    }
}
