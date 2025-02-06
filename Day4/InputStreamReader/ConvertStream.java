import java.io.*;
import java.nio.charset.Charset;

public class ConvertStream {
    public static void main(String[] args) {
        
        String filepath = "C:/Users/ayush/IdeaProjects/testing/src/main/java/org/example/java.txt"; 

        // Charset to be used for decoding the binary data (UTF-8 is commonly used)
        Charset charset = Charset.forName("UTF-8"); // You can modify this to another charset like UTF-16 if needed

        // Use try-with-resources to automatically close the BufferedReader
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Print the line as characters
                System.out.println(line);
            }

        } catch (IOException e) {
            // Print any exceptions (such as file not found or charset issues)
            e.printStackTrace();
        }
    }
}
