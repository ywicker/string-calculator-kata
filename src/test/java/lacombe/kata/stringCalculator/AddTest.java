package lacombe.kata.stringCalculator;

import lacombe.kata.IsOtherThanANumberOrACommaException;
import lacombe.kata.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddTest {
    @Test
    @DisplayName("An empty string must return 0")
    void anEmptyStringMustReturn0 () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("");

        Assertions.assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with zero must return 0")
    void aStringWithZeroMustReturn0 () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("0");

        Assertions.assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with a single positive number must return that number")
    void aStringWithASinglePositiveNumberMustReturnThatNumber () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1");

        Assertions.assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with a positive number and zero must return the positive number")
    void aStringWithAPositiveNumberAndZeroMustReturnThePositiveNumber () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1,0");

        Assertions.assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with zero and a positive number must return the positive number")
    void aStringWithZeroAndAPositiveNumberMustReturnThePositiveNumber () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("0,1");

        Assertions.assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with two positive numbers must return the sum of those")
    void aStringWithTwoPositiveNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1,1");

        Assertions.assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with two negative numbers must return the sum of those")
    void aStringWithTwoNegativeNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberOrACommaException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("-1,-1");

        Assertions.assertThat(value).isEqualTo(-2);
    }
    @Test
    @DisplayName("A string other than a number or a comma raises an exception")
    void aStringOtherThanANumberOrACommaRaisesAnException (){
        var stringCalculator = new StringCalculator();

        Assertions.assertThatThrownBy(() -> stringCalculator.add("0,a"))
                .isInstanceOf(IsOtherThanANumberOrACommaException.class);
    }

}
