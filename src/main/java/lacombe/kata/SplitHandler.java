package lacombe.kata;

public class SplitHandler {
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String NEWLINE_SEPARATOR = "\n";
    private final String[] stringValues;

    public String[] stringValues() {
        return stringValues;
    }

    public SplitHandler(final String input) {
        String cleanedInput = input;
        if(startsWithAModificationOfTheSeparator(input)) {
            cleanedInput = input.substring(input.indexOf(NEWLINE_SEPARATOR)+1);
        }
        stringValues = cleanedInput.split(NEWLINE_SEPARATOR+"|"+separator(input));
    }

    private String separator(final String input) {
        if(startsWithAModificationOfTheSeparator(input)) {
            return input.substring(2, input.indexOf(NEWLINE_SEPARATOR));
        }
        return DEFAULT_SEPARATOR;
    }

    private boolean startsWithAModificationOfTheSeparator(final String input) {
        return input.startsWith("//") && input.contains(NEWLINE_SEPARATOR);
    }
}
