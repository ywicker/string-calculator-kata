package lacombe.kata.errors;

import java.util.Arrays;

public class IsOtherThanANumberException extends Exception {
    public IsOtherThanANumberException(String[] stringValues) {
        super("'" + Arrays.toString(stringValues) + "' contains a character other than a digit");
    }
}
