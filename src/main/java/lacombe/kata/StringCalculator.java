package lacombe.kata;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        var stringValues = numbers.split(",");
        return Arrays.stream(stringValues)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
