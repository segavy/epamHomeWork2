package Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Paragraph {
    private String paragraph;
    private ArrayList<Sentence> sentences;
    private ArrayList<Sentence> sentencesNew;

    private static final Logger LOG = LoggerFactory.getLogger(Paragraph.class);

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        sentences = new ArrayList<Sentence>();
    }

    public String getParagraph() {
        return paragraph;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    //парсим абзац на предложения -- нужно ли ??????????
    public void parseParagraph() {
        LOG.debug("Paragraph parser started...");
        for (String s: paragraph.split("[.!?]")) {
            sentences.add(new Sentence(s));
        }
        //System.out.println(sentences);
    }


    public ArrayList<Sentence> getSentencesNew() {
        return sentencesNew;
    }



//    public void addSentence(Sentence sentence) {
//        this.sentences.add(sentence);
//    }
//
//    public ArrayList<Sentence> getSentences() {
//        return this.sentences;
//    }

    // не подходит, для этого метода нужно парсить предложение так, чтобы запоминать знаки препинания!!!
//    public ArrayList<Paragraph> sentencesToParagraph(ArrayList<Sentence> sentences) {
//        ArrayList<Paragraph> paragraphsNew = new ArrayList<Paragraph>();
//        String paragraphNew = "";
//        for (Sentence s: sentences) {
//            paragraphNew=paragraphNew+s;
//            paragraphsNew.add(new Paragraph(paragraphNew));
//        }
//        return paragraphsNew;
//    }


    @Override
    public String toString() {
        return "\nParagraph{" +
                //"sentences=" +
                paragraph +
                '}';
    }
}
