package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;
import lacombe.kata.errors.UnauthorizedNegativesException;

import java.util.Arrays;
import java.util.List;

public class StringTokensMapper {
    PositiveDigitValues toPositiveDigitValues(StringTokens stringTokens) throws UnauthorizedNegativesException, IsOtherThanANumberException {
        List<Integer> listIntValues = convertToIntegerListWithoutEmptyValues(stringTokens.stringValues());

        containsUnauthorizedNegatives(listIntValues);

        return new PositiveDigitValues(listIntValues);
    }

    private List<Integer> convertToIntegerListWithoutEmptyValues(String[] stringValues) throws IsOtherThanANumberException {
        try {
            return Arrays.stream(stringValues)
                    .filter(value -> !value.isEmpty())
                    .map(Integer::valueOf)
                    .toList();
        } catch (Exception e) {
            throw new IsOtherThanANumberException(stringValues);
        }
    }

    private void containsUnauthorizedNegatives(final List<Integer> intValues)
            throws UnauthorizedNegativesException {
        List<String> negativesValues = intValues.stream()
                .filter(intValue -> intValue < 0)
                .map(String::valueOf)
                .toList();
        if (!negativesValues.isEmpty()) {
            throw new UnauthorizedNegativesException(negativesValues);
        }
    }
}
