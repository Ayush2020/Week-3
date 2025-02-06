public class StringComparison {
    public static void main(String[] args) {
        // Define the number of repetitions for the string concatenation
        int repetitions = 1000000;

        // Measure the time taken by StringBuffer to concatenate "Hello" 1 million times
        long startTime = System.nanoTime();
        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Loop to append "Hello" 1 million times to the StringBuffer
        for (int i = 0; i < repetitions; i++) {
            sb.append("Hello");
        }
        // Capture the end time
        long endTime = System.nanoTime();
        // Calculate the time taken by StringBuffer
        long stringBufferTime = endTime - startTime;

        // Measure the time taken by StringBuilder to concatenate "World" 1 million times
        startTime = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            // Append "World" 1 million times to the StringBuffer (already used for "Hello")
            sb.append("World"); 
        }
        // Capture the end time
        endTime = System.nanoTime(); 
        // Calculate the time taken by StringBuilder
        long stringBuilderTime = endTime - startTime;

        // Output the time taken by both StringBuffer and StringBuilder
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");

        // Compare the times and output which one is faster
        if (stringBufferTime < stringBuilderTime) {
            System.out.println("StringBuffer is faster");
        } else if (stringBufferTime > stringBuilderTime) {
            System.out.println("StringBuilder is faster");
        } else {
            System.out.println("Both take the same time");
        }
    }
}
