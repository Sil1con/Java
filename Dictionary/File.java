import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class File {
    private static String path = "E:\\Desktop\\Content\\Words.txt";
    private static String delimiter = " - ";
    static void writeToFile(ArrayList<Line> arrayList){
        try{
            for (Line obj1 : arrayList){
                int j = 1;
                int sizeOfLineArrList = obj1.getArrayListOfWords().size();

                for (String obj2 : obj1.getArrayListOfWords()) {
                    FileWriter fw = new FileWriter(path,true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    if (j < sizeOfLineArrList){
                        bw.write(obj2+delimiter);
                        bw.close();
                        j++;
                    }
                    else {
                        bw.write(obj2 + ";\n");
                        bw.close();
                    }
                }
            }
        } catch(IOException e){
            e.fillInStackTrace();
        }
    }

    static Dictionary readFile() {
        Dictionary dict = new Dictionary();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc  = new Scanner(br);
            sc.useDelimiter(";"); // here was \n

            while(sc.hasNext()){ //here was next
                int i = 0;
                String[] words = new String[3];
                String token = sc.next();
                Scanner sc1 = new Scanner(token);
                sc1.useDelimiter(" - ");

                while(sc1.hasNext()){
                    words[i] = sc1.next();
                    i++;
                }

                Line line = new Line(words[0], words[1], words[2]);
                dict.getArrayOfLines().add(line);
            }
        }
        catch(IOException e) {
            e.fillInStackTrace();
        }
//        This code is only for testing
//        for(Line obj : dict.getArrayOfLines()){
//            System.out.print(obj.getEnglish() + " = " + obj.getUkrainian() + "; " + obj.getRussian() + ";");
//        }
        return dict;
    }


}
