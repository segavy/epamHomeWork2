import Reader.Reader;
import Reader.Parser;
import Reader.Issue;
import TextParts.Lexema;
import TextParts.Paragraph;
import TextParts.Sentence;
import TextParts.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class AppWithText {

    private static final Logger LOG = LoggerFactory.getLogger(AppWithText.class);

    public static void main(String[] args) {
        String unc = "inputFile";
        String unc2 = "testFile";

        LOG.debug("Hello !");

        Reader reader = new Reader();
        reader.readFile(unc2);

        //print text as chars. Transform after testing     ???????????????????
        reader.outputChars(reader.transformTextToArray(reader.getText()));

        //parse array of chars to own classes
        Parser parser = new Parser();
        parser.parsText(reader.transformTextToArray(reader.getText()));

        Issue issue = new Issue();
        System.out.println(parser.getText2());




        //System.out.println(parser.getAllTextInGeneralArray());



    }
}
