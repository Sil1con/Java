import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary {
    ArrayList<Line> Dictionary = new ArrayList<Line>();

    void start(){
        String englishWord;
        String ukrainianWord;
        String russianWord;
        String userInput;
        String[] words = new String[3];
        boolean stopProgram =  false;
        aa:
            while (!stopProgram == true){
            System.out.println("Select:");
            System.out.println("Add");
            System.out.println("Stop");
            System.out.println("Print");
            Scanner sc = new Scanner(System.in);
            userInput = sc.nextLine().toLowerCase();
                if (userInput.equals("add")) {
                    System.out.print("Enter the string: ");
                    userInput = sc.next();

                    readInput(userInput, words);

                    englishWord = words[0];
                    ukrainianWord = words[1];
                    russianWord = words[2];

                    Line line = new Line();
                    line.receiveWords(englishWord, ukrainianWord, russianWord);
                    line.putWordsInLine();


                    try {
                        writeInFile(line);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    Dictionary.add(line);
                }
                else if (userInput.equals("stop")){
                    print();
                    break;
                }
                else if (userInput.equals("print")){
                    try {
                        readTheFile();
                    } catch (FileNotFoundException e) {
                        e.fillInStackTrace();
                    }
                    break;
                }
                else {
                    System.out.println("Please, enter the given option");
                }
            }
    }
    void writeInFile(Line line) throws Exception {
        try {
            FileWriter file = new FileWriter("D:\\Desktop\\Folders\\Test.txt", true);
            BufferedWriter bfr = new BufferedWriter(file);
            PrintWriter pw = new PrintWriter(bfr);
            pw.println(line.lineOfWords.get(0) + "-" + line.lineOfWords.get(1) + "-" + line.lineOfWords.get(2));
            pw.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    void readTheFile() throws FileNotFoundException{
        String[] words = new String[3];
        try {
            FileReader fr = new FileReader("D:\\Desktop\\Folders\\Test.txt");
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);

            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                int i = 0;
                String token = sc.next();
                Scanner sc1 = new Scanner(token);
                sc1.useDelimiter("-");
                while(sc1.hasNext()){
                    words[i] = sc1.next();
                    i++;
                }
                Line line = new Line();
                line.receiveWords(words[0], words[1], words[2]);
                line.putWordsInLine();
                Dictionary.add(line);
            }
            print();
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
    }
    void readInput(String userInput, String[] words){
        int i = 0;
        Scanner sc = new Scanner(userInput);
        sc.useDelimiter("-");
        while(sc.hasNext()){
            String token = sc.next();
            words[i] = token;
            i++;
        }
    }
    void print(){
        for (Line obj : Dictionary){
            System.out.println(obj.lineOfWords.get(0)+ " = " + obj.lineOfWords.get(1) + "; " + obj.lineOfWords.get(2));
        }
    }

    public static void main(String[] args) {
        Dictionary d1 = new Dictionary();
        d1.start();
    }
}