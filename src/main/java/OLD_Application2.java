import OLD_TextStructure.Text2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OLD_Application2 {

    //private static final Logger LOG = LoggerFactory.getLogger(OLD_Application2.class);
    private static final Logger LOG = LoggerFactory.getLogger(OLD_Application2.class);

    public static void main(String[] args) {
        LOG.debug("Program started");

        Text2 text = new Text2();
        text.readText("inputFile");
        System.out.println(text.getParagraphs());

        text.getParagraphs();




    }
}
