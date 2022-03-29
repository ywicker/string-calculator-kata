package lacombe.kata.stringCalculator;

import lacombe.kata.errors.IsOtherThanANumberException;
import lacombe.kata.StringCalculator;
import lacombe.kata.errors.UnauthorizedNegativesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AddTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        this.stringCalculator = new StringCalculator();
    }

    @Test
    void empty_string_should_return_0() throws Exception {
        String input = "";

        int value = stringCalculator.add(input);

        assertThat(value).isZero();
    }

    @Test
    void zero_string_should_return_0() throws Exception {
        String input = "0";

        int value = stringCalculator.add(input);

        assertThat(value).isZero();
    }

    @Test
    void single_positive_number_string_should_return_same_number() throws Exception {
        String input = "1";

        int value = stringCalculator.add(input);

        int expectedValue = 1;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void positive_number_and_zero_string_should_return_positive_number() throws Exception {
        String input = "1,0";

        int value = stringCalculator.add(input);


        int expectedValue = 1;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void zero_and_positive_number_string_should_return_positive_number() throws Exception {
        String input = "0,1";

        int value = stringCalculator.add(input);

        int expectedValue = 1;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void two_positive_numbers_comma_delimited_should_be_summed() throws Exception {
        String input = "1,1";

        int value = stringCalculator.add(input);

        int expectedValue = 2;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void other_than_number_string_should_be_raises_exception() {
        String input = "0,a";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(IsOtherThanANumberException.class);
    }

    @Test
    void single_positive_number_followed_by_two_default_separators_should_return_same_number() throws Exception {
        String input = "1,\n";

        int value = stringCalculator.add(input);

        int expectedValue = 1;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void multiple_positive_numbers_comma_delimited_should_be_summed() throws Exception {
        String input = "1,2,3,4,5";

        int value = stringCalculator.add(input);

        int expectedValue = 15;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void two_positive_numbers_newline_delimited_should_be_summed() throws Exception {
        int value = stringCalculator.add("1\n1");

        int expectedValue = 2;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void multiple_positive_numbers_newline_delimited_should_be_summed() throws Exception {
        String input = "1\n2\n3\n4\n5";

        int value = stringCalculator.add(input);

        int expectedValue = 15;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void three_positive_numbers_delimited_in_two_default_way_should_be_summed() throws Exception {
        String input = "1\n2,3";

        int value = stringCalculator.add(input);

        int expectedValue = 6;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void custom_separator_followed_by_positive_number_should_return_same_number() throws Exception {
        String input = "//;\n1";

        int value = stringCalculator.add(input);

        int expectedValue = 1;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void custom_separator_followed_by_two_positive_numbers_newline_delimited_should_be_summed() throws Exception {
        String input = "//;\n1\n1";

        int value = stringCalculator.add(input);

        int expectedValue = 2;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void custom_separator_followed_by_two_positive_numbers_delimited_by_new_separator_should_be_summed() throws Exception {
        String input = "//;\n1;1";

        int value = stringCalculator.add(input);

        int expectedValue = 2;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void custom_separator_followed_by_two_positive_numbers_delimited_by_default_separator_should_be_raises_exception() {
        String input = "//;\n1,1";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(IsOtherThanANumberException.class);
    }

    @Test
    void custom_separator_followed_by_five_positive_numbers_delimited_in_two_valid_way_should_be_summed() throws Exception {
        String input = "//;\n1;2\n3;4\n5";

        int value = stringCalculator.add(input);

        int expectedValue = 15;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void custom_empty_separator_followed_by_two_positive_numbers_newline_delimited_should_be_summed() throws Exception {
        String input = "//\n1\n1";

        int value = stringCalculator.add(input);

        int expectedValue = 2;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void custom_separator_with_2_characters_followed_by_two_positive_numbers_delimited_by_new_separator_should_be_summed() throws Exception {
        String input = "//sp\n1sp1";

        int value = stringCalculator.add(input);

        int expectedValue = 2;
        assertThat(value).isEqualTo(expectedValue);
    }

    @Test
    void positive_number_followed_by_custom_separator_should_be_raises_exception() {
        String input = "1//;\n";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(IsOtherThanANumberException.class);
    }

    @Test
    void custom_separator_without_newline_followed_by_positive_number_should_be_raises_exception() {
        String input = "//;1";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(IsOtherThanANumberException.class);
    }

    @Test
    void negative_number_string_should_be_raises_exception_with_negative_value() {
        String input = "-1";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(UnauthorizedNegativesException.class)
                .hasMessage("Negatives not allowed:-1");
    }

    @Test
    void multiple_negative_numbers_should_be_raises_exception_with_negative_values() {
        String input = "-1,2,-3,4,-5";

        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(UnauthorizedNegativesException.class)
                .hasMessage("Negatives not allowed:-1 -3 -5");
    }
}
