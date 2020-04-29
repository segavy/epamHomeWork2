import Reader.Reader;
import Reader.Parser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppWithTextTest {
    private Reader reader;
    private Parser parser;

    private static final Logger LOG = LoggerFactory.getLogger(AppWithTextTest.class);

    @Before
     public void init() {
        String unc = "inputFile";
        reader = new Reader();
        reader.readFile(unc);
        parser = new Parser();
        parser.parsText(reader.transformTextToArray(reader.getText()));
    }

    @Test
    public void checkIfIncomingFileIsTheSameAsOutgoingFile() {
        LOG.debug("Test #1 started.");
        Assert.assertEquals(reader.getText(), parser.convertBackLexemaToString(parser.getTextAsList()));
        LOG.debug("Test #1 finished.");
    }

    @Test
    public void changeWordWithSubstring2TestTwoTextsShouldBeEquals() {
        LOG.debug("Test #2 started.");
        String textToCheck = new String("A constructor in Java is a special method, that is used to initialize objects.\n" +
                "AAA constructor is called when an object of a class is created. It AAA be used to AAA initial values AAA object attributes.\n" +
                "Note, that AAA constructor name must match AAA class name, AAA it cannot have a return type. Also note, that AAA constructor is called when AAA object is created.\n");
        Assert.assertEquals(textToCheck, parser.changeWordWithSubstring2(reader.getText(), "AAA", 3));
        LOG.debug("Test #2 finished.");

    }

}
