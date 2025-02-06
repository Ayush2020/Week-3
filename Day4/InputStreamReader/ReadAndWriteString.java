import java.io.*;

public class ReadAndWriteString {
    public static void main(String[] args) {
        // Define the file path where input will be written
        String filepath = "C:/Users/ayush/IdeaProjects/testing/src/main/java/org/example/java.txt";

        // Wrap System.in with InputStreamReader and BufferedReader to read user input
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(filepath, true);  // 'true' for appending
             BufferedWriter fileWriterBuffered = new BufferedWriter(fileWriter)) {

            String userInput;

            // Prompt the user to start inputting data
            System.out.println("Enter lines of text. Type 'exit' to stop.");

            // Read user input line by line until 'exit' is entered
            while (true) {
                // Read a line of input from the console
                userInput = consoleReader.readLine();
                
                // Check if the input is "exit", if so, break the loop
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                // Write the user input to the file with a new line
                fileWriterBuffered.write(userInput);
                fileWriterBuffered.newLine();
            }

            // Inform the user that their input has been written to the file
            System.out.println("Your input has been written to the file.");

        } catch (IOException e) {
            // Handle any I/O errors that may occur (e.g., file not found, read/write errors)
            e.printStackTrace();
        }
    }
}
