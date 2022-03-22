package lacombe.kata;

import lacombe.kata.errors.IsOtherThanANumberException;

import static lacombe.kata.StringNumbers.*;

public class StringCalculator {
    public int add(String numbers) throws IsOtherThanANumberException {
        var stringNumbers = buildStringNumbers(numbers);
        return stringNumbers.sumOfValues();
    }
}
