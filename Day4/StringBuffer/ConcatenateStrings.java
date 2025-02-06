public class ConcatenateStrings {

    // Method to concatenate all strings in the input array using StringBuffer
    public static String concatenateString(String[] strings) {
        // Create a new StringBuffer object to hold the concatenated result
        StringBuffer sb = new StringBuffer();

        // Loop through each string in the array
        for (String s : strings) {
            // Append the current string to the StringBuffer
            sb.append(s);
        }

        // Convert the StringBuffer content to a String and return it
        return sb.toString();
    }

    public static void main(String[] args) {
        // Initialize an array of strings to be concatenated
        String[] strings = new String[] {"a", "b", "c", "d", "e", "f"};

        // Call the concatenateString method and print the result
        System.out.println(concatenateString(strings));  // Output will be: abcdef
    }
}
