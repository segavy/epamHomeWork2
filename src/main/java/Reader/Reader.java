package Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    String text = "";

    private static final Logger LOG = LoggerFactory.getLogger(Reader.class);

//    public Reader() {
//    }

    public void readFile(String path) {
        String str;
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                text = text.concat(str).concat("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            LOG.debug("File not found, we received the next exception: ", e);

            e.printStackTrace();
        }
        //System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public char[] transformTextToArray(String text) {
        char[] chars = text.toCharArray();
        return chars;
    }

    //delete after testing
    public void outputChars(char[] chars)
    {
        for (char c: chars) {
            System.out.print(c);
        }
    }
}
