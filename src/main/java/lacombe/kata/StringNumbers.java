package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;

import java.util.Arrays;

public record StringNumbers (String[] stringValues) {
    public static StringNumbers buildStringNumbers(String numbers) {
        var stringSplitValues = numbers.split(",");

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
