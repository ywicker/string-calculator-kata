package lacombe.kata.stringCalculator;

import lacombe.kata.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTest {
    @Test
    void anEmptyStringMustReturn0 () {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("");

        Assertions.assertThat(value).isEqualTo(0);
    }
}
