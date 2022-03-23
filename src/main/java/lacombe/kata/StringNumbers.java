package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;

import java.util.Arrays;

public record StringNumbers (String[] stringValues) {
    public static StringNumbers buildStringNumbers(String numbers) {
        String separator = ",";
        if(numbers.startsWith("//") && numbers.contains( "\n")) {
            separator = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }
        var stringSplitValues = numbers.split("[\n"+separator+"]");

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
