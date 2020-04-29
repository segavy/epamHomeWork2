package Reader;

import TextParts.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Parser {
    private ArrayList<Lexema> allTextInGeneralList = new ArrayList<Lexema>();
    private ArrayList<Lexema> textAsList = new ArrayList<Lexema>();

    private static final Logger LOG = LoggerFactory.getLogger(Parser.class);

    public void parsText(char[] chars) {
        String tempWord = "";
        ArrayList<Lexema> tempSentence = new ArrayList<Lexema>();
        ArrayList<Lexema> tempParagraph = new ArrayList<Lexema>();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                tempWord = tempWord.concat(Character.toString(c));
            } else if ((Character.isSpaceChar(c)) && (!tempWord.equals(""))) {
                Word w = new Word(tempWord);
                allTextInGeneralList.add(w);
                tempSentence.add(w);
                tempWord = "";
            } else if ((c == ',') && (!tempWord.equals(""))) {
                Word w = new Word(tempWord);
                allTextInGeneralList.add(w);
                tempSentence.add(w);
                tempWord = "";
                Punctuation p = new Punctuation(c);
                allTextInGeneralList.add(p);
                tempSentence.add(p);
            } else if (c == ('.') | c == ('!') | c == ('?')) {
                Word w = new Word(tempWord);
                allTextInGeneralList.add(w);
                tempSentence.add(w);
                tempWord = "";
                Punctuation p = new Punctuation(c);
                allTextInGeneralList.add(p);
                tempParagraph.add(new Sentence(new ArrayList<Lexema>(tempSentence)));
                tempParagraph.add(p);
                tempSentence.clear();
            } else if (c == '\n') {
                Punctuation p = new Punctuation(c);
                allTextInGeneralList.add(p);
                ArrayList<Lexema> tempP = new ArrayList<Lexema>(tempParagraph);
                textAsList.add(new Paragraph(tempP));
                textAsList.add(p);
                tempParagraph.clear();
            } //else continue;
        }
        LOG.debug("Parsing of the text finished successfully.");
    }

    public ArrayList<Lexema> getTextAsList() {
        return textAsList;
    }

    public String convertBackLexemaToString(ArrayList text) {
        String outputsText = "";
        for (Lexema paragr : this.textAsList) {
            if (paragr instanceof Paragraph) {
                for (Lexema senten : ((Paragraph) paragr).getParagraph()) {
                    if (senten instanceof Sentence) {
                        for (Lexema word : ((Sentence) senten).getSentence()) {
                            if (word instanceof Word) {
                                if (((Sentence) senten).getSentence().indexOf(word) != 0) {outputsText = outputsText.concat(" ");}
                                outputsText = outputsText.concat(((Word) word).getValue());
                            } else
                            if (word instanceof Punctuation) {
                                outputsText = outputsText.concat(Character.toString(((Punctuation) word).getValue()));
                            }
                        }
                    } else
                        if (senten instanceof Punctuation) {
                            outputsText = outputsText.concat(Character.toString(((Punctuation) senten).getValue()));
                            if (((Paragraph) paragr).getParagraph().indexOf(senten) != (((Paragraph) paragr).getParagraph().size()-1)) {
                                outputsText = outputsText.concat(" ");
                            }
                        }
                }
            } else
                if (paragr instanceof Punctuation) outputsText = outputsText.concat(Character.toString(((Punctuation) paragr).getValue()));
        }
        return outputsText;
    }

    public String changeWordWithSubstring2(String incomingString, String someSubstring, int wordLength) {
        return incomingString.replaceAll("\\b[a-zA-Z]{" + wordLength + "}\\b", someSubstring);
    }

    public void changeWordWithSubstring(String someSubstring, int wordLength) {
        for (Lexema t: textAsList) {
            if (t instanceof Paragraph) {
                for (Lexema p : ((Paragraph) t).getParagraph()) {
                    if (p instanceof Sentence) {
                        String newSentence = "";
                        for (Lexema s : ((Sentence) p).getSentence()) {
                            if (s instanceof Word) {
                                newSentence = newSentence.concat(((Word) s).getValue()).concat(" ");  //  УДАЛИТЬ ПРОБЕЛ ПОСЛЕ ЗАПЯТОЙ  !!!!!
                            } else if (s instanceof Punctuation)
                                newSentence = newSentence.concat(Character.toString(((Punctuation) s).getValue())).concat(" ");
                        }
                        newSentence = newSentence.replaceAll("\\b[a-zA-Z]{" + wordLength + "}\\b", someSubstring);
                        System.out.print(newSentence);
                    } else if (p instanceof Punctuation) {
                        System.out.println(((Punctuation) p).getValue());
                    }
                }
            }
        }
        LOG.debug("Changing the words finished completely. Please check the outputted textAsList before. " +
                "The textAsList has been splits into sentences, and displayed each sentence in a new line.");
    }




//    public void createTextItems(ArrayList<Lexema> list) {
//        ArrayList<Lexema> sentence;
//        for (Lexema lex: allTextInGeneralList) {
//             if (lex instanceof Word == true) {
//                 //sentence.add(lex);
//            };
//        }
//    }


//    public String getInitialText(char[] chars) {
//        String textAsList = "";
//        for (char c : chars) {
//            textAsList.concat(Character.toString(c));
//        }
//        return textAsList;
//    }

}
