package lacombe.kata;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) throws IsOtherThanANumberOrACommaException{
        if(numbers.isEmpty()) {
            return 0;
        }
        var stringValues = numbers.split(",");
        try {
            return Arrays.stream(stringValues)
                    .mapToInt(Integer::valueOf)
                    .sum();
        } catch(Exception e){
            throw new IsOtherThanANumberOrACommaException(numbers);
        }
    }
}
