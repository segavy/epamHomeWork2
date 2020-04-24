package Reader;

import TextParts.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parser {
    private ArrayList<Lexema> allTextInGeneralArray = new ArrayList<Lexema>();
    private ArrayList<Lexema> text= new ArrayList<Lexema>();

    //ArrayList<Lexema>

    //parse the array of characters into common Lexema ArrayList
    public void parsText(char[] chars) {

        String tempWord = "";
        ArrayList<Lexema> tempSentence = new ArrayList<Lexema>();
        ArrayList<Lexema> tempParagraph = new ArrayList<Lexema>();
        //ArrayList<Lexema> text= new ArrayList<Lexema>();
        for (char c: chars) {
            //sentence = sentence.concat(Character.toString(c));
            if (Character.isLetterOrDigit(c)) {
                tempWord = tempWord.concat(Character.toString(c));
                //sentence = sentence.concat(Character)
            } else
                if ((Character.isSpaceChar(c)) && (!tempWord.equals(""))) {
                    Word w = new Word(tempWord);
                    allTextInGeneralArray.add(w);
                    tempSentence.add(w);
                    tempWord = "";
                } else
                    if ((c == ',') && (!tempWord.equals(""))) {
                        Word w = new Word(tempWord);
                        allTextInGeneralArray.add(w);
                        tempSentence.add(w);
                        tempWord = "";
                        Punctuation p = new Punctuation(c);
                        allTextInGeneralArray.add(p);
                        tempSentence.add(p);
                    } else
                        if (c == ('.') | c == ('!') | c == ('?')) {
                            Word w = new Word(tempWord);
                            allTextInGeneralArray.add(w);
                            tempSentence.add(w);
                            tempWord = "";
                            Punctuation p = new Punctuation(c);
                            allTextInGeneralArray.add(p);
                            //tempSentence.add(p);
                            //Sentence s = new Sentence(tempSentence); //     НЕ РАБОТАЕТ   ???????
                            ArrayList<Lexema> tempS = new ArrayList<Lexema>(tempSentence);
                            tempParagraph.add(new Sentence(tempS));
                            tempParagraph.add(p);

                            //System.out.println(tempParagraph);   //   РАБОТАЕТ

                            //System.out.println(tempSentence);
                            tempSentence.clear();
                        } else
                            if (c == '\n') {

                                Punctuation p = new Punctuation(c);
                                allTextInGeneralArray.add(p);
                                ArrayList<Lexema> tempP = new ArrayList<Lexema>(tempParagraph);
                                text.add(new Paragraph(tempP));
                                text.add(p);
                                //System.out.println(tempParagraph);  //  НЕ РАБОТАЕТ

                                //System.out.println(allTextInGeneralArray); //   РАБОТАЕТ
                                //tempParagraph.add(tempSentence);
                                //System.out.println();

                                //System.out.println(text);
                                tempParagraph.clear();

                            } //else continue;
        }
        //System.out.println(text);
    }

    public ArrayList<Lexema> getText2() {
        return text;
    }

    public ArrayList<Lexema> getAllTextInGeneralArray() {
        return allTextInGeneralArray;
    }

//    public void createTextItems(ArrayList<Lexema> list) {
//        ArrayList<Lexema> sentence;
//        for (Lexema lex: allTextInGeneralArray) {
//             if (lex instanceof Word == true) {
//                 //sentence.add(lex);
//            };
//        }
//    }

//    public String getInitialText(char[] chars) {
//        String text = "";
//        for (char c : chars) {
//            text.concat(Character.toString(c));
//        }
//        return text;
//    }

}
