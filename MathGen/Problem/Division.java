package Problem;

public class Division extends Problem{
    public Division(int size, int threshold, int minValue) {
        super(size, threshold, minValue);
    }
    public int[][] fillArr(){
        for (int i = 0; i < getSize(); i++){
            int rand1 = receiveRand();
            int rand2 = receiveRand();
            while (rand1 % rand2 != 0){
                rand1 = receiveRand();
                rand2 = receiveRand();
                while (rand1 == rand2){
                    rand2 = receiveRand();
                }
            }
            int[][] sample = new int[1][2];
            sample[0][0] = rand1;
            sample[0][1] = rand2;
            getArr()[i] = sample[0];
        }
        return getArr();
    }
    public void print(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(getArr()[i][0] + " / " + getArr()[i][1] + " = ");
        }
    }
}
