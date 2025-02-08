package com.tit;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class LargeFileReadingEfficiency {

    public static void readWithFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.read() != -1) {
                // Read one character at a time
            }
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + "ms");
    }

    public static void readWithInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.read() != -1) {
                // Read one character at a time (after converting bytes to characters)
            }
        }
        long endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + "ms");
    }

    public static void main(String[] args) throws IOException {
        // Specify the file path
        String filePath = "C:/Users/ayush/IdeaProjects/Main.java/src/main/java/com/tit/new.txt";  // Change this to the actual file path

        System.out.println("Reading With File Reader...");
        readWithFileReader(filePath);
        System.out.println("Reading With InputStream Reader...");
        readWithInputStreamReader(filePath);
    }
}

