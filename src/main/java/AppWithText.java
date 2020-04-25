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
        reader.readFile(unc2);
        //reader.readFile(unc);

        //print text as chars. Transform after testing     ???????????????????
//        reader.outputChars(reader.transformTextToArray(reader.getText()));

        //parse text of chars to different classes
        Parser parser = new Parser();
        parser.parsText(reader.transformTextToArray(reader.getText()));



        parser.changeWordWithSubstring("AAA", 3);

        System.out.println(parser.getTextAsArray());
        //System.out.println(parser.getAllTextInGeneralArray());


    }
}
