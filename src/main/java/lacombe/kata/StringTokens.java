package lacombe.kata;

public class StringTokens {
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String NEWLINE_SEPARATOR = "\n";
    private static final String SEPARATOR_SWITCH = "//";

    private final String[] stringValues;

    public String[] stringValues() {
        return stringValues;
    }

    public StringTokens(final String input) {
        String separator = DEFAULT_SEPARATOR;
        String cleanedInput = input;

        if (startsWithAModificationOfTheSeparator(input)) {
            separator = input.substring(DEFAULT_SEPARATOR.length(), input.indexOf(NEWLINE_SEPARATOR));
            cleanedInput = input.substring(input.indexOf(NEWLINE_SEPARATOR) + NEWLINE_SEPARATOR.length());
        }
        stringValues = cleanedInput.split("[" + NEWLINE_SEPARATOR + "|" + separator + "]");
    }

    private boolean startsWithAModificationOfTheSeparator(final String input) {
        return input.startsWith(SEPARATOR_SWITCH)
                && input.contains(NEWLINE_SEPARATOR);
    }
}
