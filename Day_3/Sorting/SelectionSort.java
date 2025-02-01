public class SelectionSort{
    public static void printArray(int score[]){
        for (int i =0; i< score.length ; i++){
            System.out.print(score[i] + " ");
        }
    }
    public static void main(String[] args) {
        int [] score = {39, 70, 32, 67, 90, 84};

        for (int i = 0; i< score.length-1; i++){
            int smallest = i;
            for (int j = i +1; j<score.length; j++){
                if (score[smallest] > score[j]){
                    smallest = j;
                }
            }
            int temp = score[smallest];
            score[smallest] = score[i];
            score[i] = temp;
        }
        printArray(score);
    }
}