package lacombe.kata.stringCalculator;

import lacombe.kata.errors.IsOtherThanANumberException;
import lacombe.kata.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AddTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        this.stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("An empty string must return 0")
    void anEmptyStringMustReturn0 () throws IsOtherThanANumberException {
        int value = stringCalculator.add("");

        assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with zero must return 0")
    void aStringWithZeroMustReturn0 () throws IsOtherThanANumberException {
        int value = stringCalculator.add("0");

        assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with a single positive number must return that number")
    void aStringWithASinglePositiveNumberMustReturnThatNumber () throws IsOtherThanANumberException {
        int value = stringCalculator.add("1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with a positive number and zero must return the positive number")
    void aStringWithAPositiveNumberAndZeroMustReturnThePositiveNumber () throws IsOtherThanANumberException {
        int value = stringCalculator.add("1,0");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with zero and a positive number must return the positive number")
    void aStringWithZeroAndAPositiveNumberMustReturnThePositiveNumber () throws IsOtherThanANumberException {
        int value = stringCalculator.add("0,1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with two positive numbers must return the sum of those")
    void aStringWithTwoPositiveNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        int value = stringCalculator.add("1,1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with two negative numbers must return the sum of those")
    void aStringWithTwoNegativeNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        int value = stringCalculator.add("-1,-1");

        assertThat(value).isEqualTo(-2);
    }
    @Test
    @DisplayName("A string other than a number raises an exception")
    void aStringOtherThanANumberRaisesAnException (){
        assertThatThrownBy(() -> stringCalculator.add("0,a"))
                .isInstanceOf(IsOtherThanANumberException.class);
    }
    @Test
    @DisplayName("A string with multiple positive numbers must return the sum of those")
    void aStringWithMultiplePositiveNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        int value = stringCalculator.add("1,2,3,4,5");

        assertThat(value).isEqualTo(15);
    }
    @Test
    @DisplayName("A string with multiple positive and negative numbers must return the sum of those")
    void aStringWithMultiplePositiveAndNegativeNumbersMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        int value = stringCalculator.add("-1,2,-3,4,-5");

        assertThat(value).isEqualTo(-3);
    }
    @Test
    @DisplayName("A string with two positive numbers separated by a newline must return the sum of those")
    void aStringWithTwoPositiveNumbersSeparatedByANewlineMustReturnTheSumOfThose () throws IsOtherThanANumberException {
        int value = stringCalculator.add("1\n1");

        assertThat(value).isEqualTo(2);
    }

}
