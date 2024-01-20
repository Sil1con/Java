import java.util.ArrayList;
public class Line {
    private String englishWord;
    private String ukrainianWord;
    private String russianWord;
    ArrayList<String> lineOfWords = new ArrayList<String>();

    void receiveWords(String englishWord, String ukrainianWord, String russianWord){
        this.englishWord = englishWord;
        this.ukrainianWord = ukrainianWord;
        this.russianWord = russianWord;
    }

    void putWordsInLine(){
        lineOfWords.add(0, englishWord);
        lineOfWords.add(1, ukrainianWord);
        lineOfWords.add(2, russianWord);
    }
}
