package beverage;

public abstract class Beverage {
    private int sizeOfCup;
    private int sugarAmount;
    final public void setSize(int userInput){
        sizeOfCup = userInput;
    }
    final public int getSize(){
        return sizeOfCup;
    }
    final public void setSugarAmount(int userInput){
        sugarAmount = userInput;
    }
    final public int getSugarAmount(){
        return sugarAmount;
    }
}
