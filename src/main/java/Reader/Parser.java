package Reader;

import TextParts.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Parser {
    private ArrayList<Lexema> allTextInGeneralArray = new ArrayList<Lexema>();
    private ArrayList<Lexema> text= new ArrayList<Lexema>();

    //parse the array of characters into common Lexema ArrayList
    public void parsText(char[] chars) {
        String tempWord = "";
        ArrayList<Lexema> tempSentence = new ArrayList<Lexema>();
        ArrayList<Lexema> tempParagraph = new ArrayList<Lexema>();
        for (char c: chars) {
            if (Character.isLetterOrDigit(c)) {
                tempWord = tempWord.concat(Character.toString(c));
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
                            //ArrayList<Lexema> tempS = new ArrayList<Lexema>(tempSentence);
                            tempParagraph.add(new Sentence(new ArrayList<Lexema>(tempSentence)));
                            tempParagraph.add(p);
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

    public ArrayList<Lexema> getTextAsArray() {
        return text;
    }

    public ArrayList<Lexema> getAllTextInGeneralArray() {
        return allTextInGeneralArray;
    }

//    public ArrayList<Lexema> createCopy(ArrayList<Lexema> list) {
//        ArrayList<Lexema> newList = new ArrayList();
//        for (Lexema lex: list) {
//            newList.add(lex);
//        }
//        return newList;
//    }

//    public String getSentence (Sentence s) {
//        String sent = "";
//        return sent;
//    }


    public void changeWordWithSubstring(String someSubstring, int wordLength) {
        for (Lexema t: text) {
            if (t instanceof Paragraph) {
                for (Lexema p: ((Paragraph) t).getParagraph()) {
                    if (p instanceof Sentence) {
                        String newSentence = "";
                        for (Lexema s: ((Sentence) p).getSentence()) {
                            if (s instanceof Word) {
                                newSentence = newSentence.concat(((Word) s).getValue()).concat(" ");
                            } else
                                if (s instanceof Punctuation) newSentence = newSentence.concat(Character.toString(((Punctuation) s).getValue())).concat(" ");

//                                if (((Word) s).checkLength(wordLength)) {
//                                    System.out.print(((Word) s).getValue());
//                                    ((Word) s).changeWordWithSubstring(someSubstring);
//                                    System.out.println(((Word) s).getValue());
                                }
                        newSentence = newSentence.replaceAll("\\b[a-zA-Z]{" + wordLength + "}\\b", someSubstring);
                        //sentenceNew = sentence.replaceAll("\\b[a-zA-Z]{" + letterCount + "}\\b", word);

                        System.out.print(newSentence);

                    } else
                        if (p instanceof Punctuation) {
                            System.out.println(((Punctuation) p).getValue());
                        }
                 //       }
           //         }
                }
            }
        }



//        for (Lexema txt: allTextInGeneralArray) {
//            if ( txt instanceof Word) {
//                if (((Word) txt).checkLength(wordLength)) {
//                    ((Word) txt).setValue(someSubstring);
//                    //System.out.println(txt);
//                }
//            }
//        }
//        //return str;
//        //System.out.println(copyAllTextInGeneralArray);
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
