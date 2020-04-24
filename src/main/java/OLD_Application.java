import OLD_Text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OLD_Application {

    private static final Logger LOG = LoggerFactory.getLogger(OLD_Application.class);

    public static void main(String[] args) {
        LOG.debug("Program started");

        Text text = new Text("");
        text.readText("inputFile");

        text.parserText();   // - разбиваем текст на абзацы

        //-------------------------------- Парсим текст на параграфы и предложения ----  не нужно??????
        text.parseParagraphs();

        text.changeWordsInParagraphs("AAAAA", 5);
    }
}
