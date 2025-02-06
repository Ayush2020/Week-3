import java.io.*;

public class WordCount {
    public static void main(String[] args) {
        // File path of the text file to be read (modify to the correct path)
        String filepath = "C:/Users/ayush/IdeaProjects/testing/src/main/java/org/example/java.txt";

        // Word we want to count occurrences of
        String targetWord = "Word";

        // Initialize counter for word occurrences
        int wordCount = 0;

        // Use try-with-resources to automatically close the BufferedReader after use
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the current line into words based on spaces
                String[] words = line.split("\\s+");

                // Loop through each word in the current line
                for (String word : words) {
                    // Check if the word matches the target word (case-insensitive comparison)
                    if (word.equalsIgnoreCase(targetWord)) {
                        // Increment the counter if the word matches
                        wordCount++;
                    }
                }
            }

            // Output the final count of occurrences of the target word
            System.out.println("Targeted '" + targetWord + "' : " + wordCount + " times");

        } catch (IOException e) {
            // If there is an IOException (like the file not found or read issues), print the error
            e.printStackTrace();
        }
    }
}
