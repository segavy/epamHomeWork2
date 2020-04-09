package Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    private String text = "";
    private ArrayList<String> paragraphs;
    private String filePath;

    private static final Logger LOG = LoggerFactory.getLogger(Text.class);

    public Text(String filePath) {
        this.filePath = filePath;
        //ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
    }

    public void readText() {
        LOG.debug("Read text started...");
        String str;
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                text = text + str + "\n";
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

    public void textParser() {
        //ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
        for (String s:text.split(".")) {
            paragraphs.add(s);
        }
        //return paragraphs;
    }

    public ArrayList getParagraph() {
        return paragraphs;
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs= " + paragraphs +
                '}';
    }
}
