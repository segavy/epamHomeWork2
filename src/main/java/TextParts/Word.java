package TextParts;

public class Word implements Lexema{
    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String str) {
        value = value.replace(value, str);
    }

    public boolean checkLength(int length) {
        return value.length() == length;
    }


    public String changeWordWithSubstring (String substring) {  //   а нужен ли  ????
        return this.value = substring;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
