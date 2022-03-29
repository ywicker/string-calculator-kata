package lacombe.kata;

public class StringCalculator {
    public int add(String input) throws Exception {
        StringTokens stringTokens = new StringTokens(input);

        var stringTokensMapper = new StringTokensMapper();

        var positiveDigitValues = stringTokensMapper.toPositiveDigitValues(stringTokens);

        return positiveDigitValues.sum();
    }
}
