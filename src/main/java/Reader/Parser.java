package Reader;

import TextParts.*;

import java.util.ArrayList;

public class Parser {
    ArrayList<Lexema> partsOfText = new ArrayList<Lexema>();

    //parse the array of characters into common Lexema ArrayList
    public void parsText(char[] chars) {
        String word = "";
        String sentence = "";
        String paragraph = "";
        for (char c: chars) {
            if (Character.isLetterOrDigit(c) == true) {
                word = word.concat(Character.toString(c));
            } else
                if ((Character.isSpaceChar(c) == true) && (word != "")) {
                    partsOfText.add(new Word(word));
                    word = "";
                } else
                    if (c == ('.') | c == ('!') | c == ('?') | (c == ',')) {
                        partsOfText.add(new Word(word));
                        word = "";
                        partsOfText.add(new Punctuation(c));
                    } else
                        if (c == '\n') {

                            //partsOfText.add(new Punctuation(c));
                        }
        }
    }

    public ArrayList<Lexema> getPartsOfText() {
        return partsOfText;
    }

    public void createTextItems(ArrayList<Lexema> list) {

        ArrayList<Lexema> sentence;
        for (Lexema lex: partsOfText) {
             if (lex instanceof Word == true) {
                 sentence.add(lex);

            };
        }

    }

}
