package Problem;
import java.io.IOException;

public abstract class Problem {


    private static int threshold;
    private static int minValue;
    private int[][] arr;
    private int size;
    public int getSize(){return size;}
    public int getThreshold(){return threshold;}
    public int getMinValue(){return minValue;}
    public int[][] getArr(){return arr;}
    Problem(int size, int threshold, int minValue){
        Problem.threshold = threshold;
        Problem.minValue = minValue;
        this.size = size;
        arr = new int[size][2];
        fillArr();
    }
    public int receiveRand(){
        int rand = (int)(Math.random() * threshold) + minValue;
        return rand;
    }
    public int[][] fillArr(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < 2; j++){
                arr[i][j] = receiveRand();
            }
        }
        return arr;
    }
    public void print(){}
    public void writeToFile() throws IOException {}
}
