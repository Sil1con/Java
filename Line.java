
import java.util.ArrayList;
public class Line {
    private String english;
    private String ukrainian;
    private String russian;
    private ArrayList<String> arrayListOfWords = new ArrayList<String>();
    public Line(String english, String ukrainian, String russian){
        this.english = english;
        this.ukrainian = ukrainian;
        this.russian = russian;
        arrayListOfWords.add(0, english);
        arrayListOfWords.add(1, ukrainian);
        arrayListOfWords.add(2, russian);
    }
    public ArrayList<String> getArrayListOfWords(){
        return arrayListOfWords;
    }
    public String getEnglish(){
        return english;
    }
    public String getUkrainian(){
        return ukrainian;
    }
    public String getRussian(){
        return russian;
    }
}
