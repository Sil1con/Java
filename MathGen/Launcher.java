import Problem.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Launcher{
    private String userInput;
    private boolean stopProgram;
    private ArrayList<String> arrayList = new ArrayList<>();
    private static String amountOfProb = "How many problems do you want to receive";
    private static String exceptionText = "Something bad happened";
    private static String finishedProcess = "Check the file, the problems were created";
    private int sizeOfArr;
    private static String newLine = "\n";
    public void start() {
        System.out.println("Hello, you are in auto-generator of simple math problems." + newLine);
        System.out.println("You have several types of problems:");

        while (!stopProgram) {
            System.out.println(newLine + "1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Mix (doesn't work)" + newLine);
            System.out.println("'Stop'" + " will finish the program" + newLine);
            Scanner sc = new Scanner(System.in);
            System.out.print("Your choice: ");
            userInput = sc.next().toLowerCase();

            switch (userInput) {
                case "":
                    System.out.println("Please, put relevant information");
                    break;

                case "stop":
                    System.out.println("Bye");
                    stopProgram = true;
                    break;

                case "addition":
                    System.out.println(amountOfProb);
                    System.out.print("Your choice: ");
                    userInput = sc.next().toLowerCase();

                    if (userInput.isEmpty()) {
                        continue;
                    }
                    sizeOfArr = Integer.parseInt(userInput);

                    Addition add = new Addition(sizeOfArr, 150, 40);
                    for (int i = 0; i < sizeOfArr; i++){
                        String str;
                        str = add.getArr()[i][0] + " + " + add.getArr()[i][1];
                        arrayList.add(str);
                    }
                    try{
                        File.writeToFile(arrayList);
                    } catch(IOException ex) {
                        ex.fillInStackTrace();
                    }
                    break;

                case "subtraction":
                    System.out.println(amountOfProb);
                    System.out.print("Your choice: ");
                    userInput = sc.next().toLowerCase();

                    if (userInput.isEmpty()) {
                        continue;
                    }
                    sizeOfArr = Integer.parseInt(userInput);
                    Subtraction sub = new Subtraction(sizeOfArr, 150, 40);
                    for (int i = 0; i < sizeOfArr; i++){
                        String str;
                        str = sub.getArr()[i][0] + " - " + sub.getArr()[i][1];
                        arrayList.add(str);
                    }
                    try{
                        File.writeToFile(arrayList);
                    } catch(IOException ex) {
                        ex.fillInStackTrace();
                    }

                    break;
                case "multiplication":
                    System.out.println(amountOfProb);
                    System.out.print("Your choice: ");
                    userInput = sc.next().toLowerCase();
                    if (userInput.isEmpty()) {
                        continue;
                    }
                    sizeOfArr = Integer.parseInt(userInput);
                    Multiplication mul = new Multiplication(sizeOfArr, 15, 2);
                    for (int i = 0; i < sizeOfArr; i++){
                        String str;
                        str = mul.getArr()[i][0] + " * " + mul.getArr()[i][1];
                        arrayList.add(str);
                    }
                    try{
                        File.writeToFile(arrayList);
                    } catch(IOException ex) {
                        ex.fillInStackTrace();
                    }

                    break;

                case "division":
                    System.out.println(amountOfProb);
                    System.out.print("Your choice: ");
                    userInput = sc.next().toLowerCase();
                    if (userInput.isEmpty()) {
                        continue;
                    }
                    sizeOfArr = Integer.parseInt(userInput);
                    Division div = new Division(sizeOfArr, 150, 2);
                    for (int i = 0; i < sizeOfArr; i++){
                        String str;
                        str = div.getArr()[i][0] + " / " + div.getArr()[i][1];
                        arrayList.add(str);
                    }
                    try{
                        File.writeToFile(arrayList);
                    } catch(IOException ex) {
                        ex.fillInStackTrace();
                    }

                    break;

                case "mix":
                    System.out.println(amountOfProb);
                    System.out.print("Your choice: ");
                    userInput = sc.next().toLowerCase();
                    if (userInput.isEmpty()) {
                        continue;
                    }
                    sizeOfArr = Integer.parseInt(userInput);

                    ArrayList<String> arrayList = fillArrList(sizeOfArr);

                    try {
                        File.writeToFile(arrayList);
                    } catch (IOException ex) {
                        ex.fillInStackTrace();
                    }
                    System.out.println(finishedProcess);
                    break;
            }
        }
    }
    private ArrayList<String> fillArrList(int size){

        for (int i = 0; i < size; i++){
            int randNum = (int)(Math.random() * 4) + 1;
            String str;

            switch (randNum) {
                case 1:
                    Multiplication mul = new Multiplication(1, 15, 3);
                    str = mul.getArr()[0][0] + " * " + mul.getArr()[0][1];
                    arrayList.add(str);
                    break;
                case 2:
                    Division div = new Division(1, 100, 3);
                    str = div.getArr()[0][0] + " / " + div.getArr()[0][1];
                    arrayList.add(str);
                    break;
                case 3:
                    Addition add = new Addition(1, 200, 45);
                    str = add.getArr()[0][0] + " + " + add.getArr()[0][1];
                    arrayList.add(str);
                    break;
                case 4:
                    Subtraction sub = new Subtraction(1, 200, 65);
                    str = sub.getArr()[0][0] + " - " + sub.getArr()[0][1];
                    arrayList.add(str);
                    break;
                default:
                    System.out.println("Hi");
            }
        }
        return arrayList;
    }

    public static void main(String[] args){
        Launcher l1 = new Launcher();
        l1.start();
    }
}