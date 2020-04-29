package TextParts;

public class Punctuation implements Lexema{
    private char punctuation;

    public Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    public char getValue() {
        return punctuation;
    }

    public String addPunctuationToString(String str) {
        str = str.concat(Character.toString(this.punctuation));
        return str;
    }

    @Override
    public String toString() {
        return "Punctuation{" +
                "punctuation='" + punctuation + "\'" +
                '}';
    }

}
