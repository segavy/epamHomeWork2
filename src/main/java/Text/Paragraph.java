package Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Paragraph {
    private String paragraph;
    private ArrayList<Sentence> sentences;

    private static final Logger LOG = LoggerFactory.getLogger(Text.class);

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        sentences = new ArrayList<Sentence>();
    }

    public String getParagraph() {
        return paragraph;
    }

    public void parserParagraph() {
        LOG.debug("Paragraph parser started...");
        for (String s: paragraph.split("[.!?]")) {
            sentences.add (new Sentence(s));
        }
        System.out.println(sentences);
    }

    public void parseSentenceInParagraph(String word, int count) {
        for (Sentence s: sentences) {
            s.changeWord(word, count);
        }
    }

//    public void addSentence(Sentence sentence) {
//        this.sentences.add(sentence);
//    }
//
//    public ArrayList<Sentence> getSentences() {
//        return this.sentences;
//    }

    @Override
    public String toString() {
        return "\nParagraph{" +
                "sentences=" + paragraph +
                '}';
    }
}
