import java.util.*;

public class CircularTour{
    public static int tour(int[] petrol, int[] distance){
        int n = petrol.length;

        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < n;  i++){
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            if (currentSurplus < 0 ){
                start = i + 1;
                currentSurplus = 0;
            }
        }
        if (totalSurplus < 0 ){
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 10};
        int[] distance = {6, 8, 5, 4};

        int start = tour(petrol, distance);

        if (start == -1){
            System.out.println("No Solution exists.");
        }else{
            System.out.println("The Starting petrol pump is at index : " + start);
        }
    }
}