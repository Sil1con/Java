import java.util.ArrayList;
import java.util.Scanner;
public class Dictionary {
    private boolean programStop;
    private String userInput;
    private Scanner sc;
    private ArrayList<Line> arrayOfLines = new ArrayList<Line>();
    static int limit = 10;
    public ArrayList<Line> getArrayOfLines(){
        return arrayOfLines;
    }
    public void startProgram(){
        System.out.println("Hello, you are in Dictionary");
        System.out.println("In order to choose options, just write the name of the option in brackets \n");
        System.out.println("You have several options:");
        System.out.println("1) Write word (write)");
        System.out.println("2) Print the dictionary (print)");
        System.out.println("3) Repeat words (repeat)");
        System.out.println("4) Stop the program (stop)" + "\n");
        while(!programStop){

            System.out.println("\n" + "1. write; 2. print; 3. repeat; 4. stop");

            System.out.print("Your choice: ");
            sc = new Scanner(System.in);
            userInput = sc.next().toLowerCase();

            switch (userInput){
                case "stop":
                    print(arrayOfLines);
                    File.writeToFile(arrayOfLines);
                    programStop = true;
                    break;

                case "write":
                    System.out.println("Instructions:");
                    System.out.println("1) You should write words in a proper sequence");
                    System.out.println("    english word - ukrainian word - russian word");
                    System.out.println("2) Please, check the correctness of written twice");

                    System.out.println("Input: ");
                    sc = new Scanner(System.in);
                    userInput = sc.nextLine().toLowerCase();
                    if (userInput.isEmpty()){
                        continue;
                    }
                    allocateWordsInLine(userInput);
                    break;

                case "print":
                    if (arrayOfLines.isEmpty()){
                        System.out.println("Your current dictionary is empty" + "\n");
                    } else {
                        print(arrayOfLines);
                    }
                    break;
                case "repeat":
                    // repeatWords();
                    repeatWords();
                    //print(File.readFile());//An overloaded print(Dictionary) method
            }
        }
    }
    void print(ArrayList<Line> arrayOfLines){
        for (Line obj : arrayOfLines) {
            System.out.println(obj.getEnglish() + " = " +obj.getUkrainian() + "; " + obj.getRussian());
        }
    }
    public void allocateWordsInLine(String userInput){
        int i = 0;
        String[] words = new String[3];

        sc = new Scanner(userInput);
        sc.useDelimiter(" - ");
        while(sc.hasNext()){
            String token = sc.next();
            words[i] = token;
            i++;
        }
        Line line = new Line(words[0], words[1], words[2]);
        arrayOfLines.add(line);
    }

    public void repeatWords(){
        ArrayList<Line> copyOfDict = File.readFile().getArrayOfLines();
        ArrayList<Line> arrListOfWrongAnswers = new ArrayList<Line>();
        sc = new Scanner(System.in);
        for(int i = 0; i < limit; i++){
            int rand = (int)(Math.random() * copyOfDict.size());

            Line copyOfLine = copyOfDict.get(rand);
            System.out.println(copyOfLine.getEnglish());
            System.out.println("Answer:");
            userInput = sc.nextLine().toLowerCase();

            if (userInput.equals(copyOfLine.getRussian())){
                System.out.println("Cool, you are right");
            } else if (userInput.equals(copyOfLine.getUkrainian())) {
                System.out.println("Cool, that's a right answer");
            } else {
                System.out.println("Your answer is wrong" + "\n");
                arrListOfWrongAnswers.add(copyOfLine);
                //I must create a session file for repetition;
            }
        }
        print(arrListOfWrongAnswers);
    }
}