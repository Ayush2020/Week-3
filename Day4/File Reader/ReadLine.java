import java.io.*;

public class ReadLine {
    public static void main(String[] args) {
        // Specify the path of the file to read
        String filePath = "C:/Users/ayush/IdeaProjects/testing/src/main/java/org/example/java.txt";

        // Declare FileReader and BufferedReader objects
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Initialize the FileReader to read the file at the specified path
            fileReader = new FileReader(filePath);

            // Wrap the FileReader with BufferedReader to read the file more efficiently
            bufferedReader = new BufferedReader(fileReader);

            // Variable to store each line read from the file
            String line;

            // Loop through the file and read each line
            while ((line = bufferedReader.readLine()) != null){
                // Print the line to the console
                System.out.println(line);
            }
        } catch (IOException e) {
            // Catch and print any input-output exceptions (e.g., file not found)
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                // Ensure the BufferedReader is closed after reading is complete
                if (bufferedReader != null){
                    bufferedReader.close();
                }
                // Ensure the FileReader is closed after reading is complete
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                // Catch and print any exceptions while closing the resources
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
