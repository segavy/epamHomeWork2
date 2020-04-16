package Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    private String text;
    private ArrayList<Paragraph> paragraphs;
    private ArrayList<Paragraph> paragraphsNew;

    private static final Logger LOG = LoggerFactory.getLogger(Text.class);

    public Text(String text) {
        this.text = text;
        paragraphs = new ArrayList<Paragraph>();
    }

    // Прочитали текст из файла и сохранили в переменную text
    public void readText(String filePath) {
        LOG.debug("Reading text started...");
        String str;
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                text = text.concat(str).concat("\r\n");
            }
            //System.out.println(text);
        } catch (FileNotFoundException e) {
            LOG.debug("File not found.");
        }
    }



    public String getText() {
        return text;
    }

    //Разбиваем текст на абзацы
    public void parserText() {
        LOG.debug("Text parser started...");
        for (String s:text.split("\\r\\n")) {
            paragraphs.add(new Paragraph(s));
        }
    }

    //не нужно???
    public ArrayList getParagraphs() {
        return paragraphs;
    }

    //??????????????????????????????????????? не нужно
    public void parseParagraphs() {
        for (Paragraph p: paragraphs) {
            p.parseParagraph();
        }
    }

    ///* пытамся вставить строку вместо слов
    public void changeWordsInParagraphs(String word, int letterCount) {
        paragraphsNew = new ArrayList<Paragraph>();
        for (Paragraph p: paragraphs) {
            //LOG.debug("1 - changeWordsInParagraph started...");
            ArrayList<Sentence> sentencesNew = new ArrayList<Sentence>();
            //sentencesNew = p.getSentences();
            for (Sentence s: p.getSentences()) {    //   ------   какой-то косяк  !!!!!!!!!!!!!!! -----
                //LOG.debug("2 - changeWordsInParagraphs started...");
                String sNew = s.changeWord(word, letterCount);
                sentencesNew.add(new Sentence(sNew));
                //System.out.println(sNew);
                //LOG.debug("2 - changeWordsInParagraphs finished...");
            }
            //LOG.debug("1 - changeWordsInParagraph finished...");
            System.out.println(p.getSentencesNew());

            //paragraphsNew.add(new Paragraph(p));
            //p.parseSentenceInParagraph(word, letterCount) = new Paragraph();
        }
        //return paragraphsNew;
    }
    //*/

    public void getTextNew() {
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs= " + text +
                '}';
    }
}
