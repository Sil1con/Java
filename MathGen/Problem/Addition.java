package Problem;
public class Addition extends Problem{
    public Addition(int size, int threshold, int minValue){
        super(size, threshold, minValue);
    }
    public void print(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(getArr()[i][0] + " + " + getArr()[i][1] + " = ");
        }
    }
}