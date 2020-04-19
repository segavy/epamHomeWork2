package OLD_TextStructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Text2 {
    private String text;
    private ArrayList<Paragraph2> paragraphs;

    private static final Logger LOG = LoggerFactory.getLogger(Text2.class);

    public Text2() {
        //this.text = text;
        paragraphs = new ArrayList<Paragraph2>();
    }

    public void readText(String filePath) {
        LOG.debug("Reading text started...");
        String str;
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                paragraphs.add(new Paragraph2(str));
                text += str + "\n";  // text = text.concat(str).
            }
        } catch (FileNotFoundException e) {
            LOG.debug("File not found.");
        }
    }

    public ArrayList<Paragraph2> getParagraphs() {
        return paragraphs;
    }


}
