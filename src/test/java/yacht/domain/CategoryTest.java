package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    void 카테고리는_이름을_가진다() {
        //when & then
        assertThat(Category.ONES.getName()).isEqualTo("Ones");
        assertThat(Category.TWOS.getName()).isEqualTo("Twos");
        assertThat(Category.THREES.getName()).isEqualTo("Threes");
        assertThat(Category.CHOICE.getName()).isEqualTo("Choice");
    }

    @Test
    void Ones_카테고리는_1의_개수를_합산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(1), new Dice(3),
                new Dice(4), new Dice(5)
        ));

        //when
        int score = Category.ONES.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(2);
    }
}
