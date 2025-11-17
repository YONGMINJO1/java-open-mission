package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨_번호를_생설할_수_있다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        //then
        assertThat(winningNumbers).isNotNull();

    }
}
