package com.tit;

public class StringConcatenationPerformance {
    public static String concatenateWithString(int numStrings, String str){
        String result = "";
        for(int i = 0; i<numStrings; i++){
            result += str;
        }
        return result;
    }
    public static String concatenateWithStringBuilder(int numStrings, String str){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<numStrings; i++){
            result.append(str);
        }
        return result.toString();
    }
    public static String concatenateWithStringBuffer(int numStrings, String str){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<numStrings; i++){
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int numStrings = 1000000;
        String str ="test";

        long startTime = System.nanoTime();
        String resultStringBuffer = concatenateWithStringBuffer(numStrings, str);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1_000_000 + "ms");

        startTime = System.nanoTime();
        String resultStringBuilder = concatenateWithStringBuilder(numStrings, str);
        endTime =System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");

        startTime =System.nanoTime();
        String result = concatenateWithString(numStrings, str);
        endTime =System.nanoTime();
        System.out.println((endTime - startTime)/1000000 + "ms");




    }

}
