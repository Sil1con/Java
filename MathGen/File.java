import Problem.Problem;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class File {
    private static String newLine = "\n";
    private static String path = "E:\\Desktop\\Content\\Problems.txt";
    public static void writeToFile(ArrayList<String> arrayList) throws IOException{
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        int i = 1;
        for (String obj : arrayList){
            bw.write("№" + i + " " + obj + " = " + newLine);
            i++;
        }
        bw.close();
    }
}
