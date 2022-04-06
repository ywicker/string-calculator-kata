package lacombe.kata;

public record StringTokensBuilder(String input) {
    private static final String NEWLINE_SEPARATOR_VALUE = Separator.NEWLINE_SEPARATOR.value();
    private static final String SEPARATOR_SWITCH = "//";

    public Separator buildSeparator() {
        if(startsWithAModificationOfTheSeparator()){
            return new Separator(input.substring(SEPARATOR_SWITCH.length() - 1, input.indexOf(NEWLINE_SEPARATOR_VALUE)));
        }
        return Separator.DEFAULT_SEPARATOR;
    }

    public String buildInputWithoutCustomSeparator(final Separator separator) {
        if(startsWithAModificationOfTheSeparator()){
            return input.substring(input.indexOf(NEWLINE_SEPARATOR_VALUE) + NEWLINE_SEPARATOR_VALUE.length());
        }
        return input;
    }

    public String[] buildSplitString(final String inputWithoutCustomSeparator, final Separator separator) {
        return inputWithoutCustomSeparator.split("[" + NEWLINE_SEPARATOR_VALUE + "|" + separator.value() + "]");
    }

    private boolean startsWithAModificationOfTheSeparator() {
        return input.startsWith(SEPARATOR_SWITCH)
                && input.contains(NEWLINE_SEPARATOR_VALUE);
    }
}
