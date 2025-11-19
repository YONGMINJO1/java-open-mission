package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class DicesTest {

    @Test
    void 주사위_5개를_생성한다() {
        //given
        List<Dice> diceList = List.of(
                new Dice(1),
                new Dice(2),
                new Dice(3),
                new Dice(4),
                new Dice(5));

        //when
        Dices dices = new Dices(diceList);

        //then
        assertThat(dices.getValues()).hasSize(5);
    }

    @Test
    void 주사위는_5개여쟈_한다() {
        //given
        List<Dice> diceList = List.of(
                new Dice(1),
                new Dice(2),
                new Dice(3));

        //when & then
        assertThatThrownBy(() -> new Dices(diceList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5개");
    }

    @Test
    void 특정_숫자의_개수를_셀_수_있다() {
        // given
        List<Dice> diceList = List.of(
                new Dice(1), new Dice(1), new Dice(3),
                new Dice(4), new Dice(5)
        );
        Dices dices = new Dices(diceList);

        //when & then
        assertThat(dices.countValue(1)).isEqualTo(2);
        assertThat(dices.countValue(2)).isEqualTo(0);
        assertThat(dices.countValue(3)).isEqualTo(1);
    }

    @Test
    void 모든_주사위의_합을_계산할_수_있다() {
        //given
        List<Dice> diceList = List.of(
                new Dice(1),
                new Dice(2),
                new Dice(3),
                new Dice(4),
                new Dice(5)
        );
        Dices dices = new Dices(diceList);

        //when
        int sum = dices.sumAll();

        //then
        assertThat(sum).isEqualTo(15);
    }

    @Test
    void 주사위_5개를_무작위로_생성할_수_있다() {
        //when
        Dices dices = Dices.roll();

        //then
        assertThat(dices.getValues()).hasSize(5);
    }

    @Test
    void 같은_숫자_4개_이상이_있으면_그_숫자를_반환한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(3), new Dice(3), new Dice(3),
                new Dice(3), new Dice(5)
        ));

        //when
        int value = dices.getFourOfAKindValue();

        //then
        assertThat(value).isEqualTo(3);
    }

    @Test
    void 같은_숫자_4개가_없으면_0을_반환한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(3),
                new Dice(4), new Dice(5)
        ));

        //when
        int value = dices.getFourOfAKindValue();

        //then
        assertThat(value).isEqualTo(0);
    }

    @Test
    void 모두_같은_숫자면_그_숫자를_반환한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(5), new Dice(5), new Dice(5),
                new Dice(5), new Dice(5)
        ));

        //when
        int value = dices.getFourOfAKindValue();

        //then
        assertThat(value).isEqualTo(5);
    }
}
