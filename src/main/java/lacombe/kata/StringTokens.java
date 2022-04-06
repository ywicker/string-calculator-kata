package lacombe.kata;

public class StringTokens {
    private final String[] stringValues;

    public String[] stringValues() {
        return stringValues;
    }

    public StringTokens(final String input) {
        StringTokensBuilder stringTokensBuilder = new StringTokensBuilder(input);
        Separator separator = stringTokensBuilder.buildSeparator();
        String inputWithoutCustomSeparator = stringTokensBuilder.buildInputWithoutCustomSeparator(separator);
        stringValues = stringTokensBuilder.buildSplitString(inputWithoutCustomSeparator, separator);
    }
}
