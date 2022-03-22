package lacombe.kata;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        var stringValues = numbers.split(",");
        return Integer.parseInt(stringValues[0]);
    }
}
