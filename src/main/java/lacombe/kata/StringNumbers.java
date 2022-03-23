package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;

import java.util.Arrays;

public record StringNumbers (String[] stringValues) {
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String NEWLINE_SEPARATOR = "\n";

    public static StringNumbers buildStringNumbers(String numbers) {
        String separator = DEFAULT_SEPARATOR;
        if(numbers.startsWith("//") && numbers.contains(NEWLINE_SEPARATOR)) {
            separator = numbers.substring(2, numbers.indexOf(NEWLINE_SEPARATOR));
            numbers = numbers.substring(numbers.indexOf(NEWLINE_SEPARATOR)+1);
        }
        var stringSplitValues = numbers.split("["+NEWLINE_SEPARATOR+separator+"]");

        return new StringNumbers(stringSplitValues);
    }

    public int sumOfValues() throws IsOtherThanANumberException {
        try {
            return Arrays.stream(stringValues)
                    .filter(value -> !value.isEmpty())
                    .mapToInt(Integer::valueOf)
                    .sum();
        } catch (Exception e) {
            throw new IsOtherThanANumberException(stringValues);
        }
    }
}
