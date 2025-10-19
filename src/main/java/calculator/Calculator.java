package calculator;

public class Calculator {

    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (text.startsWith("//") && text.contains("\\n")) {
            int idx = text.indexOf("\\n");
            text = text.substring(0, idx) + '\n' + text.substring(idx + 2);
        }

        CustomDelimiter cd = CustomDelimiter.tryParse(text);
        String[] tokens;
        if (cd != null) {
            tokens = DefaultDelimiter.splitByChar(cd.getContent(), cd.getDelimiter());
        } else {
            tokens = DefaultDelimiter.split(text);
        }

        int sum = 0;

        for (String token : tokens) {
            if (token == null || token.isEmpty()) {
                throw new IllegalArgumentException();
            }
            int num;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        return sum;
    }
}
