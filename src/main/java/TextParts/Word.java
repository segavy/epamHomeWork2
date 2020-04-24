package TextParts;

public class Word implements Lexema{
    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String changeWordWithSubstring (String substring) {
        return this.value = substring;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
