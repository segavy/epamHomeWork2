import Reader.Reader;
import Reader.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppWithText {

    private static final Logger LOG = LoggerFactory.getLogger(AppWithText.class);

    public static void main(String[] args) {
        String unc = "inputFile";
        String unc2 = "testFile";

        LOG.debug("Program started.");

        Reader reader = new Reader();
        reader.readFile(unc);
        //reader.readFile(unc2);

        LOG.debug("We have the next text on the input:");
        reader.outputChars(reader.transformTextToArray(reader.getText()));
        System.out.println();

        Parser parser = new Parser();
        parser.parsText(reader.transformTextToArray(reader.getText()));


//        System.out.println();
//        parser.changeWordWithSubstring("AAA", 3);

        LOG.debug("Another solution:");
        System.out.println(parser.changeWordWithSubstring2(reader.getText(), "AAA", 3));

        System.out.println();
        System.out.println(parser.convertBackLexemaToString(parser.getTextAsList()));

    }
}
