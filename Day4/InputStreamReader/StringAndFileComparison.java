import java.io.*;

public class StringAndFileComparison {
    
    // Method to concatenate strings 1,000,000 times using StringBuilder
    public static long testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        String str = "hello";
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        
        return endTime - startTime; // Return time in nanoseconds
    }

    // Method to concatenate strings 1,000,000 times using StringBuffer
    public static long testStringBuffer() {
        StringBuffer sbf = new StringBuffer();
        String str = "hello";
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbf.append(str);
        }
        long endTime = System.nanoTime();
        
        return endTime - startTime; // Return time in nanoseconds
    }

    // Method to count words in a file using FileReader
    public static long countWordsWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long wordCount = 0;

        long startTime = System.nanoTime();
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length; // Split by whitespace characters
        }
        long endTime = System.nanoTime();
        
        br.close();
        return endTime - startTime; // Return time in nanoseconds
    }

    // Method to count words in a file using InputStreamReader
    public static long countWordsWithInputStreamReader(String filePath) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        BufferedReader br = new BufferedReader(isr);
        String line;
        long wordCount = 0;

        long startTime = System.nanoTime();
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length; // Split by whitespace characters
        }
        long endTime = System.nanoTime();
        
        br.close();
        return endTime - startTime; // Return time in nanoseconds
    }

    public static void main(String[] args) {
        // Test StringBuilder vs StringBuffer
        long timeStringBuilder = testStringBuilder();
        long timeStringBuffer = testStringBuffer();
        
        System.out.println("Time taken for StringBuilder: " + timeStringBuilder + " ns");
        System.out.println("Time taken for StringBuffer: " + timeStringBuffer + " ns");

        // Read a large text file and count words using FileReader vs InputStreamReader
        String filePath = "C:/Users/ayush/IdeaProjects/testing/src/main/java/org/example/java.txt"; 
        try {
            long timeFileReader = countWordsWithFileReader(filePath);
            long timeInputStreamReader = countWordsWithInputStreamReader(filePath);
            
            System.out.println("Time taken for FileReader: " + timeFileReader + " ns");
            System.out.println("Time taken for InputStreamReader: " + timeInputStreamReader + " ns");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
