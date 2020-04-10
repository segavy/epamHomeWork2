package Text;

import java.util.ArrayList;

public class Sentence {
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public String changeWord(String word, int count) {
        return(sentence.replaceAll("\\b[a-zA-Z]{" + count + "}\\b", word));
    }

    @Override
    public String toString() {
        return "\n" + sentence;
    }
}
