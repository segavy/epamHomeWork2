import Text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        LOG.debug("Program started");


        Text text = new Text("inputFile");
        text.readText();
        System.out.println(text.getText());

        //text.textParser();
        System.out.println(text.getParagraph());




    }
}
