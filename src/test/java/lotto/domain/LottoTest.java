package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또는_6개의_번호를_가진다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void 로또번호는_6개여야_한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");

    }

    @Test
    void 로또번호는_1부터_45_사이여야_한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        //when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }
}
