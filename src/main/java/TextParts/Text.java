package TextParts;

import java.util.ArrayList;

public class Text implements Lexema{
    private ArrayList<Lexema> text;

    public Text(ArrayList<Lexema> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text=" + text +
                '}';
    }
}
