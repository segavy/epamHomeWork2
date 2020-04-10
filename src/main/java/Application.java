import Text.Text;
import Text.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.debug("Program started");

        Text text = new Text("inputFile");
        text.readText();
        //System.out.println(text.getText());

        text.parserText();
        System.out.println(text.getParagraph());

        //for (Paragraph par: )
        text.parseParagraphInText();

        //System.out.println(ArrayList< Text.Sentence >);

        Parser parser = new Parser();




    }
}
