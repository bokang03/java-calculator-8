package calculator;

public class CustomDelimiter {
    private final char delimiter;
    private final String content;

    private CustomDelimiter(char delimiter, String content) {
        this.delimiter = delimiter;
        this.content = content;
    }

    public char getDelimiter() {
        return delimiter;
    }

    public String getContent() {
        return content;
    }

    public static CustomDelimiter tryParse(String text) {
        if (text == null || !text.startsWith("//")) {
            return null;
        }
        int idx = text.indexOf('\n');
        if (idx < 0) {
            return null;
        }
        String delimiterPart = text.substring(2, idx);
        if (delimiterPart.isEmpty()) {
            return null;
        }
        char delimiter = delimiterPart.charAt(0);
        String content = text.substring(idx + 1);
        return new CustomDelimiter(delimiter, content);
    }
}