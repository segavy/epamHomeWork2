import Text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.debug("Program started");

        Text text = new Text("");
        text.readText("inputFile");
        //System.out.println(text.getText());


        text.parserText();   // - разбиваем текст на абзацы
        //System.out.println(text.getParagraphs());   //Список параграфов текстом


        //-------------------------------- Парсим текст на параграфы и предложения ----  не нужно??????
        text.parseParagraphs();

        //Parser parser = new Parser();
        //parser.changeWord("AAA", 5);

        text.changeWordsInParagraphs("AAAAA", 5);

    }
}
