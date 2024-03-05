package Problem;
public class Multiplication extends Problem{
    public Multiplication(int size, int threshold, int minValue){
        super(size, threshold, minValue);
    }
    public void print(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(getArr()[i][0] + " * " + getArr()[i][1] + " = ");
        }
    }
}
