package lacombe.kata.errors;

import java.util.List;

public class UnauthorizedNegativesException extends Exception {
    public UnauthorizedNegativesException(final List<String> negativeValues){
        super("Negatives not allowed:"+ String.join(" ",negativeValues));
    }
}
