package lacombe.kata.stringCalculator;

import lacombe.kata.errors.IsOtherThanANumberException;
import lacombe.kata.StringCalculator;
import lacombe.kata.errors.UnauthorizedNegativesException;
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
    void anEmptyStringMustReturn0 () throws Exception {
        int value = stringCalculator.add("");

        assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with zero must return 0")
    void aStringWithZeroMustReturn0 () throws Exception {
        int value = stringCalculator.add("0");

        assertThat(value).isEqualTo(0);
    }
    @Test
    @DisplayName("A string with a single positive number must return that number")
    void aStringWithASinglePositiveNumberMustReturnThatNumber () throws Exception {
        int value = stringCalculator.add("1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with a positive number and zero must return the positive number")
    void aStringWithAPositiveNumberAndZeroMustReturnThePositiveNumber () throws Exception {
        int value = stringCalculator.add("1,0");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with zero and a positive number must return the positive number")
    void aStringWithZeroAndAPositiveNumberMustReturnThePositiveNumber () throws Exception {
        int value = stringCalculator.add("0,1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with two positive numbers separated by a comma must return the sum of those")
    void aStringWithTwoPositiveNumbersSeparatedByACommaMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("1,1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string other than a number raises an exception")
    void aStringOtherThanANumberRaisesAnException (){
        assertThatThrownBy(() -> stringCalculator.add("0,a"))
                .isInstanceOf(IsOtherThanANumberException.class);
    }
    @Test
    @DisplayName("A string with multiple positive numbers separated by a comma must return the sum of those")
    void aStringWithMultiplePositiveNumbersSeparatedByACommaMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("1,2,3,4,5");

        assertThat(value).isEqualTo(15);
    }
    @Test
    @DisplayName("A string with two positive numbers separated by a newline must return the sum of those")
    void aStringWithTwoPositiveNumbersSeparatedByANewlineMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("1\n1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with multiple positive numbers separated by a newline must return the sum of those")
    void aStringWithMultiplePositiveNumbersSeparatedByANewlineMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("1\n2,3");

        assertThat(value).isEqualTo(6);
    }
    @Test
    @DisplayName("A string with a change of separator and a single positive number must return that number")
    void aStringWithAChangeOfSeparatorAndASinglePositiveNumberMustReturnThatNumber () throws Exception {
        int value = stringCalculator.add("//;\n1");

        assertThat(value).isEqualTo(1);
    }
    @Test
    @DisplayName("A string with a change of separator and two positive numbers separated by a newline must return the sum of those")
    void aStringWithAChangeOfSeparatorAndTwoPositiveNumbersSeparatedByANewlineMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("//;\n1\n1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with a change of separator and two positive numbers separated by the separator must return the sum of those")
    void aStringWithAChangeOfSeparatorAndTwoPositiveNumbersSeparatedByTheSeparatorMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("//;\n1;1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with a change of separator and two positive numbers separated by the default separator raises an exception")
    void aStringWithAChangeOfSeparatorAndTwoPositiveNumbersSeparatedByTheDefaultSeparatorRaisesAnException () {
        assertThatThrownBy(() -> stringCalculator.add("//;\n1,1"))
                .isInstanceOf(IsOtherThanANumberException.class);
    }
    @Test
    @DisplayName("A string with a change of separator and multiple positive numbers separated by the separator and a newline must return the sum of those")
    void aStringWithAChangeOfSeparatorAndMultiplePositiveNumbersSeparatedByTheSeparatorAndANewlineMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("//;\n1;2\n3;4\n5");

        assertThat(value).isEqualTo(15);
    }
    @Test
    @DisplayName("A string with a change of separator for an empty and two positive numbers separated by a newline must return the sum of those")
    void aStringWithAChangeOfSeparatorForAnEmptyAndTwoPositiveNumbersSeparatedByANewlineMustReturnTheSumOfThose () throws Exception {
        int value = stringCalculator.add("//\n1\n1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with a change of separator containing 2 characters and two positive numbers separated by the separator must return the sum of those")
    void aStringWithAChangeOfSeparatorContaining2CharactersAndTwoPositiveNumbersSeparatedByTheSeparatorMustReturnTheSumOfThose() throws Exception {
        int value = stringCalculator.add("//sp\n1sp1");

        assertThat(value).isEqualTo(2);
    }
    @Test
    @DisplayName("A string with a negative number raises an exception")
    void aStringWithANegativeNumberRaisesAnException () {
        assertThatThrownBy(() -> stringCalculator.add("-1"))
                .isInstanceOf(UnauthorizedNegativesException.class)
                .hasMessage("Negatives not allowed:-1");
    }

    @Test
    @DisplayName("A string with multiple negative numbers raises an exception")
    void aStringWithMultipleNegativeNumbersRaisesAnException () {
        assertThatThrownBy(() -> stringCalculator.add("-1,2,-3,4,-5"))
                .isInstanceOf(UnauthorizedNegativesException.class)
                .hasMessage("Negatives not allowed:-1 -3 -5");
    }
}
