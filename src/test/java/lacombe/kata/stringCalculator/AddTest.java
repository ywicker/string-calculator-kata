package lacombe.kata.stringCalculator;

import lacombe.kata.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddTest {
    @Test
    @DisplayName("An empty string must return 0")
    void anEmptyStringMustReturn0 () {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("");

        Assertions.assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with zero must return 0")
    void aStringWithZeroMustReturn0 () {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("0");

        Assertions.assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with a single positive number must return that number")
    void aStringWithASinglePositiveNumberMustReturnThatNumber () {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1");

        Assertions.assertThat(value).isEqualTo(1);
    }

}
