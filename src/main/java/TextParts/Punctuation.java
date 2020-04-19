package TextParts;

public class Punctuation implements Lexema{
    private char punctuation;

    public Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    public char getPunctuation() {
        return punctuation;
    }

    @Override
    public String toString() {
        return "Punctuation{" +
                "punctuation='" + punctuation + "\'" +
                '}';
    }
}
