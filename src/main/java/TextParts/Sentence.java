package TextParts;

import java.util.ArrayList;

public class Sentence implements Lexema {
    private ArrayList<Lexema> sentence;

    public Sentence(ArrayList<Lexema> sentence) {
        this.sentence = sentence;
    }

    public ArrayList<Lexema> getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence=" + sentence +
                '}';
    }

    //    public void addTosentence(Lexema lex) {
//        sentence.add(lex);
//    }

}
