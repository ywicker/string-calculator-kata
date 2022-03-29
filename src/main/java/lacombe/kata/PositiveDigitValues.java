package lacombe.kata;

import java.util.List;

public record PositiveDigitValues(List<Integer> values) {
    public int sum() {
        return values
                .stream()
                .reduce(0, Integer::sum);
    }
}
