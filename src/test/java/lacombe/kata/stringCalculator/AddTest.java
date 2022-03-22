package lacombe.kata.stringCalculator;

import lacombe.kata.errors.IsOtherThanANumberException;
import lacombe.kata.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AddTest {
    @Test
    @DisplayName("An empty string must return 0")
    void anEmptyStringMustReturn0 () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("");

        assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with zero must return 0")
    void aStringWithZeroMustReturn0 () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("0");

        assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with a single positive number must return that number")
    void aStringWithASinglePositiveNumberMustReturnThatNumber () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with a positive number and zero must return the positive number")
    void aStringWithAPositiveNumberAndZeroMustReturnThePositiveNumber () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1,0");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with zero and a positive number must return the positive number")
    void aStringWithZeroAndAPositiveNumberMustReturnThePositiveNumber () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("0,1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with two positive numbers must return the sum of those")
    void aStringWithTwoPositiveNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("1,1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with two negative numbers must return the sum of those")
    void aStringWithTwoNegativeNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        var stringCalculator = new StringCalculator();

        int value = stringCalculator.add("-1,-1");

        assertThat(value).isEqualTo(-2);
    }
    @Test
    @DisplayName("A string other than a number or a comma raises an exception")
    void aStringOtherThanANumberOrACommaRaisesAnException (){
        var stringCalculator = new StringCalculator();

        assertThatThrownBy(() -> stringCalculator.add("0,a"))
                .isInstanceOf(IsOtherThanANumberException.class);
    }

}
