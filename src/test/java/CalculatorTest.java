import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void getSumOfSplitString () {
        String input = "1,2:3";
        Calculator calculator = new Calculator();
        Integer expected = calculator.getSum(input);

        assertThat(expected).isEqualTo(6);
    }

    @Test
    @DisplayName("기본 구분자 외에 커스텀 구분자를 지정할 수 있다.")
    void assignCustomSeparator() {
        String input = "//;\n1;2;3";
        Calculator calculator = new Calculator();
        Integer expected = calculator.getSum(input);

        assertThat(expected).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 을 반환")
    void throwErrorWhenInputContainsNegativeOrNotNumber() {
        String input = "a:b:c";
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.getSum(input)).isInstanceOf(RuntimeException.class);
    }
}
