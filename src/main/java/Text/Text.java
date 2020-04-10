package Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    private String text = "";
    private ArrayList<Paragraph> paragraphs;
    private String filePath;

    private static final Logger LOG = LoggerFactory.getLogger(Text.class);

    public Text(String filePath) {
        this.filePath = filePath;
        paragraphs = new ArrayList<Paragraph>();
    }

    public void readText() {
        LOG.debug("Read text started...");
        String str;
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                text += str + "\n";
            }
        } catch (FileNotFoundException e) {
            LOG.debug("File not found.");
        }
    }

    public String getText() {
        return text;
    }

//    public void addParagraph(Paragraph paragraph) {
//        this.paragraphs.add(paragraph);
//    }

    public void parserText() {
        LOG.debug("Text parser started...");
        //ArrayList<String> strParagraph = new ArrayList();
        //ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
        for (String s:text.split("\\n")) {
            //strParagraph.add(s);
            //System.out.println(s);
            //Paragraph par = new Paragraph(s);  //   НЕ РАБОТАЕТ  !!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //System.out.println(par);
            paragraphs.add(new Paragraph(s));
        }
//        for (String s: strParagraph)
//            paragraphs.add(new Paragraph(s));
        //return paragraphs;
    }

    public ArrayList getParagraph() {
        return paragraphs;
    }

    public void parseParagraphInText() {
        for (Paragraph p: paragraphs) {
            p.parserParagraph();
        }
    }



    @Override
    public String toString() {
        return "Text{" +
                "paragraphs= " + text +
                '}';
    }
}
