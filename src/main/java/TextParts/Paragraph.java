package TextParts;

import java.util.ArrayList;

public class Paragraph implements Lexema{
    private ArrayList<Lexema> paragraph;

    public Paragraph(ArrayList<Lexema> paragraph) {
        this.paragraph = paragraph;
    }

    public ArrayList<Lexema> getParagraph() {
        return paragraph;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "paragraph=" + paragraph +
                '}';
    }
}
