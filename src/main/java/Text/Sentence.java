package Text;

import java.util.ArrayList;

public class Sentence {
    private String sentence;
    private String sentenceNew;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public String changeWord(String word, int letterCount) {
        sentenceNew = sentence.replaceAll("\\b[a-zA-Z]{" + letterCount + "}\\b", word);

        System.out.println(sentenceNew);
        return sentenceNew;
    }

    @Override
    public String toString() {
        return
                //"Sentence{" +
                "sentence='" +
                sentence + '\'' +
                '}';
    }
}
