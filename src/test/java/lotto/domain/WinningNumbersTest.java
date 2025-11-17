package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 보너스_번호는_1부터_45_사이여야_한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        //when & then
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

    @Test
    void 보너스_번호는_당첨_번호와_중복되지_않아야_한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        //when & then
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 로또와_일치하는_개수를_셀_수_있다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //when
        int matchCount = winning.countMatches(lotto);

        //then
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    void 일치하는_번호가_없으면_0을_반환한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));

        //when
        int matchCount = winning.countMatches(lotto);

        //then
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    void 모두_일치하면_6을_반환한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int matchCount = winning.countMatches(lotto);

        //then
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void 보너스_번호가_일치하면_true를_반환한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        boolean hasBonus = winning.hasBonusMatch(lotto);

        //then
        assertThat(hasBonus).isTrue();
    }

    @Test
    void 보너스_번호가_일치하지_않으면_false를_반환한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //when
        boolean hasBonus = winning.hasBonusMatch(lotto);

        //then
        assertThat(hasBonus).isFalse();
    }

    @Test
    void _6개_일치하면_1등() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoRank rank = winning.check(lotto);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void _5개_일치_보너스_일치하면_2등() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        LottoRank rank = winning.check(lotto);

        //then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void _5개_일치_보너스_불일치하면_3등() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //when
        LottoRank rank = winning.check(lotto);

        //then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void _2개_이하_일치하면_null() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winning = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 10, 11, 12, 13));

        //when
        LottoRank rank = winning.check(lotto);

        //then
        assertThat(rank).isNull();
    }
}
