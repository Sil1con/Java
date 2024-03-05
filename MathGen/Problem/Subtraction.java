package Problem;
public class Subtraction extends Problem{
    public Subtraction(int size, int threshold, int minValue){
        super(size, threshold, minValue);
    }

    public int[][] fillArr(){
        for (int i = 0; i < getSize(); i++){
            for (int j = 0; j < 2; j++){
                getArr()[i][j] = receiveRand();
            }
            if (getArr()[i][0] < getArr()[i][1]) {
                int token = getArr()[i][0];
                getArr()[i][0] = getArr()[i][1];
                getArr()[i][1] = token;
            }
        }
        return getArr();
    }
    public void print(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(getArr()[i][0] + " - " + getArr()[i][1] + " = ");
        }
    }
}