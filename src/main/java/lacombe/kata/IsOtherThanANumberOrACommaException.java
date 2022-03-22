package lacombe.kata;

public class IsOtherThanANumberOrACommaException extends Exception {
    IsOtherThanANumberOrACommaException(String numbers) {
        super("'" + numbers + "' contains a character other than a digit or a comma");
    }
}
