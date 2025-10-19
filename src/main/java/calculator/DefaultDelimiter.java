package calculator;

import java.util.ArrayList;
import java.util.List;

public class DefaultDelimiter {
    private static final char[] defaultDelimiter = new char[] { ',', ':' };

    private DefaultDelimiter() { }

    public static String[] split(String text) {
        return splitByChars(text, defaultDelimiter);
    }

    public static String[] splitByChar(String text, char delimiter) {
        return splitByChars(text, new char[] { delimiter });
    }


    private static String[] splitByChars(String s, char[] delimiters) {
        if (s == null || s.isEmpty()) {
            return new String[0];
        }
        List<String> parts = new ArrayList<>();
        int start = 0;
        outer:
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (char d : delimiters) {
                if (c == d) {
                    parts.add(s.substring(start, i));
                    start = i + 1;
                    continue outer;
                }
            }
        }
        parts.add(s.substring(start));
        return parts.toArray(new String[0]);
    }
}