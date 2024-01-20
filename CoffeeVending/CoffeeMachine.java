import beverage.Beverage;
import beverage.Coffee.Latte;
import beverage.Coffee.Espresso;
import java.util.Scanner;

public class CoffeeMachine {
    void receiveInput(){
        Scanner sc;
        String userInput;
        System.out.println("Please, choose the option:");
        System.out.println("Latte");
        System.out.println("Espresso");
        System.out.println("Your choice: ");
        sc = new Scanner(System.in);
        userInput = sc.next().toLowerCase();
        switch (userInput){
            case "latte":
                Latte latte = new Latte();
                checkAmountOfMoney(userInput, latte.getPrice(), latte);
                break;
            case "espresso":
                Espresso esp = new Espresso();
                checkAmountOfMoney(userInput, esp.getPrice(), esp);
                break;
        }
    }
    void checkAmountOfMoney(String beverage, double price, Beverage drink){
        double balance = 0;
        Scanner sc;
        while (balance < price) {
            sc = new Scanner(System.in);
            System.out.println("Amount of money on balance is " + balance);
            System.out.println("The price is " + price);
            System.out.println("How much do you want to deposit?");
            System.out.println("Deposit: ");
            balance+=Double.parseDouble(sc.next());
        }
        if (balance > price) {
            float rest = (float)balance - (float)price;
            System.out.println("Your rest is " + rest);
            makeCoffee(beverage, drink);

        }
        if (balance == price){
            makeCoffee(beverage, drink);
        }
    }
    void makeCoffee(String typeOfCoffee, Beverage drink){
        Scanner sc;
        int answer;
        switch (typeOfCoffee.toLowerCase()){
            case "latte":
                System.out.println("Please, choose size of cup");
                System.out.println("1) 350 ml");
                System.out.println("2) 250 ml");
                System.out.println("3) 150 ml");
                sc = new Scanner(System.in);
                System.out.println("Enter your choice:");
                answer = Integer.parseInt(sc.next());
                drink.setSize(answer);
                System.out.println("Please, choose needed amount of sugar");
                System.out.println("1) 2 g");
                System.out.println("2) 5 g");
                System.out.println("3) 7 g");
                System.out.println("4) 10 g");
                answer = Integer.parseInt(sc.next());
                drink.setSugarAmount(answer);
                System.out.println("Your cup of Latte is ready!");
                System.out.println("Take it and enjoy!");
                break;
            case "espresso":
                System.out.println("Please, choose size of cup");
                System.out.println("1) 60 ml");
                System.out.println("2) 30 ml");
                sc = new Scanner(System.in);
                System.out.println("Enter your choice:");
                answer = Integer.parseInt(sc.next());
                drink.setSize(answer);
                System.out.println("Please, choose needed amount of sugar");
                System.out.println("1) 2 g");
                System.out.println("2) 5 g");
                System.out.println("3) 7 g");
                answer = Integer.parseInt(sc.next());
                drink.setSugarAmount(answer);
                System.out.println("Your cup of Espresso is ready!");
                System.out.println("Take it and enjoy!");
                break;
        }

    }
}