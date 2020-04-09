package Text;

import java.util.ArrayList;

public class Paragraph {
    private String paragraph;
    private ArrayList<Sentence> sentences;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        ArrayList<Sentence> sentences = new ArrayList<Sentence>();
    }

    public void addSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public ArrayList<Sentence> getSentences() {
        return this.sentences;
    }

    public void paragraphParser(String paragraph) {

    }

    @Override
    public String toString() {
        return paragraph;
    }
}
