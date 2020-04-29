package Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private String text = "";

    private static final Logger LOG = LoggerFactory.getLogger(Reader.class);

    public void readFile(String path) {
        String str;
        File file = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                text = text.concat(str).concat("\n");
            }
        } catch (FileNotFoundException e) {
            LOG.debug("File not found, please review the text exception: ", e);
            System.exit(0);
        } //finally {scanner.close();}
    }

    public String getText() {
        return text;
    }

    public char[] transformTextToArray(String text) {
        return text.toCharArray();
    }

    public void outputChars(char[] chars)
    {
        for (char c: chars) {
            System.out.print(c);
        }
    }

}
