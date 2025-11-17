package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 로또를_생성할_수_있다() {
        //given
        LottoGenerator generator = new LottoGenerator();

        //when
        Lotto lotto = generator.generate();

        //then
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void 생성된_로또는_1부터_45_사이의_숫자다() {
        //given
        LottoGenerator generator = new LottoGenerator();

        //when
        Lotto lotto = generator.generate();

        //then
        assertThat(lotto.getNumbers())
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    void 생성된_로또는_중복이_없다() {
        //given
        LottoGenerator generator = new LottoGenerator();

        //when
        Lotto lotto = generator.generate();

        //then
        assertThat(lotto.getNumbers())
                .doesNotHaveDuplicates();
    }
}
