public class LinearSearchWord {

    // Method to search for the word in the list of sentences
    public static String searchWordInSentence(String[] sentences, String word) {
        // Loop through each sentence in the array of sentences
        for (String sentence : sentences) {
            // Check if the current sentence contains the specified word
            if (sentence.contains(word)) {
                // If the word is found, return the sentence
                return sentence;
            }
        }
        // If no sentence contains the word, return "Not Found"
        return "Not Found";
    }

    public static void main(String[] args) {
        // Array of sentences to search through
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a powerful programming language.",
                "Linear search is simple to implement.",
                "Searching for words in a list is easy."
        };

        // The word to search for in the sentences
        String word = "Linear";

        // Call the searchWordInSentence method and store the result
        String result = searchWordInSentence(sentences, word);

        // Print the result 
        System.out.println(result);
    }
}
