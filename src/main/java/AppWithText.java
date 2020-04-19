import Reader.Reader;
import Reader.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppWithText {

    private static final Logger LOG = LoggerFactory.getLogger(AppWithText.class);

    public static void main(String[] args) {
        String unc = "inputFile";
        String unc2 = "testFile";

        LOG.debug("Hello !");

        Reader reader = new Reader();
        reader.readFile(unc2);

        //print text as chars
        reader.outputChars(reader.transformTextToArray(reader.getText()));

        //parse array of chars to own classes
        Parser parser = new Parser();
        parser.parsText(reader.transformTextToArray(reader.getText()));

        System.out.println(parser.getPartsOfText());

    }
}
