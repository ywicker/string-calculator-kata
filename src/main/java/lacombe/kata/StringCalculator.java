package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) throws IsOtherThanANumberException {
        SplitHandler splitHandler = new SplitHandler(input);

        return sumOfValues(splitHandler.stringValues());
    }

    public int sumOfValues(final String[] stringValues) throws IsOtherThanANumberException {
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
