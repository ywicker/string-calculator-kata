package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;
import lacombe.kata.errors.UnauthorizedNegativesException;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String input) throws Exception {
        SplitHandler splitHandler = new SplitHandler(input);

        return sumOfValues(splitHandler.stringValues());
    }

    private int sumOfValues(final String[] stringValues) throws Exception {
        List<Integer> listIntValues;
        try {
            listIntValues = Arrays.stream(stringValues)
                .filter(value -> !value.isEmpty())
                .map(Integer::valueOf)
                .toList();
        } catch (Exception e) {
            throw new IsOtherThanANumberException(stringValues);
        }
        containsUnauthorizedNegatives(listIntValues);

        return listIntValues
                .stream()
                .reduce(0, Integer::sum);
    }

    private void containsUnauthorizedNegatives(final List<Integer> intValues) throws Exception {
        List<String> negativesValues = intValues.stream()
                .filter(intValue -> intValue < 0)
                .map(String::valueOf)
                .toList();
        if(!negativesValues.isEmpty()) {
            throw new UnauthorizedNegativesException(negativesValues);
        }
    }
}
