import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ApplicationOLD {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationOLD.class);
    public static void main(String[] args) throws FileNotFoundException {

        String newString="";

        LOG.debug("Program started");

        String str = "An interpreter for printf-style format strings. " +
                "This class provides support for layout justification and alignment, common formats for numeric, string, " +
                "and date/time data, and locale-specific output. " +
                "Common Java types such as byte, BigDecimal, and Calendar are supported. " +
                "Limited formatting customization for arbitrary user types is provided through the Formattable interface.\n" +
                "Formatters are not necessarily safe for multithreaded access. Thread safety is optional and is the responsibility of users of methods in this class." +
                "\n" +
                "Formatted printing for the Java language is heavily inspired by C's printf. " +
                "Although the format strings are similar to C, " +
                "some customizations have been made to accommodate the Java language and exploit some of its features. " +
                "Also, Java formatting is more strict than C's; for example, if a conversion is incompatible with a flag, " +
                "an exception will be thrown. In C inapplicable flags are silently ignored. " +
                "The format strings are thus intended to be recognizable to C programmers " +
                "but not necessarily completely compatible with those in C.\n";
        //System.out.println(str);

        // Разделение абзаца на предложения
        ArrayList<String> sentence = new ArrayList();
        for (String s:str.split("[.!?]")) {
            sentence.add(s);
        }
        //System.out.println(sentence);

//        for (String s1: sentence) {
//            newString = newString.concat(s1+". ");
//        }

        //System.out.println(newString);
        //System.out.printf("hello %s and %d \n", 2+1, 4);

        try {
            readfile();
            LOG.debug("Reading the file");
        } catch (FileNotFoundException e) {
            LOG.debug("Program work");
            System.out.println("Method main");
        }

        int count = 5;
        String result = str.replaceAll("\\b[a-zA-Z]{" + count + "}\\b", "AAA");
        System.out.println(result);

        readfile();
    }

    public static void readfile() throws FileNotFoundException {
        String inputText;
        File file = new File("inputFile");
        //OLD_Text text = new OLD_Text("");
        Scanner scanner = new Scanner(file);
        //Scanner scanner2 = new Scanner(new File(""));
        while (scanner.hasNextLine()) {
            String sss = scanner.nextLine();
            System.out.println(sss);
        }
    }

}
