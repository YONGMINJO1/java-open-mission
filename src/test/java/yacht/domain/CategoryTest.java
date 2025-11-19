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

    @Test
    void Twos_카테고리는_2의_개수를_합산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(2), new Dice(2), new Dice(2),
                new Dice(4), new Dice(5)
        ));

        //when
        int score = Category.TWOS.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(6);
    }

    @Test
    void Threes_카테고리는_3의_개수를_합산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(3), new Dice(1), new Dice(2),
                new Dice(4), new Dice(5)
        ));

        //when
        int score = Category.THREES.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(3);
    }

    @Test
    void Choice_카테고리는_모든_주사위의_합을_계산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(3),
                new Dice(4), new Dice(5)
        ));

        //when
        int score = Category.CHOICE.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(15);
    }

    @Test
    void Fours_카테고리는_4의_개수를_합산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(4), new Dice(4), new Dice(4),
                new Dice(1), new Dice(2)
        ));

        //when
        int score = Category.FOURS.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(12);
    }

    @Test
    void Fives_카테고리는_5의_개수를_합산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(5), new Dice(5), new Dice(1),
                new Dice(2), new Dice(3)
        ));

        //when
        int score = Category.FIVES.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(10);
    }

    @Test
    void Sixes_카테고리는_6의_개수를_합산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(6), new Dice(6), new Dice(6),
                new Dice(6), new Dice(1)
        ));

        //when
        int score = Category.SIXES.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(24);
    }

    @Test
    void FourOfAKind_카테고리는_모든_주사위의_총합을_계산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(3), new Dice(3), new Dice(3),
                new Dice(3), new Dice(5)
        ));

        //when
        int score = Category.FOUR_OF_A_KIND.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(17);
    }

    @Test
    void FourOfAKind_카테고리는_4개가_없으면_0점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(3),
                new Dice(4), new Dice(5)
        ));

        //when
        int score = Category.FOUR_OF_A_KIND.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(0);
    }

    @Test
    void FourOfAKind_카테고리는_5개_모두_같으면_총합을_계산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(6), new Dice(6), new Dice(6),
                new Dice(6), new Dice(6)
        ));

        //when
        int score = Category.FOUR_OF_A_KIND.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(30);
    }

    @Test
    void Yacht_카테고리는_5개가_모두_같으면_50점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(6), new Dice(6), new Dice(6),
                new Dice(6), new Dice(6)
        ));

        //when
        int score = Category.YACHT.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(50);
    }

    @Test
    void Yacht_카테고리는_하나라도_다르면_0점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(6), new Dice(6), new Dice(6),
                new Dice(6), new Dice(5)
        ));

        //when
        int score = Category.YACHT.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(0);
    }

    @Test
    void FullHouse_카테고리는_3개와_2개_패턴이면_총합을_계산한다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(3), new Dice(3), new Dice(3),
                new Dice(5), new Dice(5)
        ));

        //when
        int score = Category.FULL_HOUSE.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(19);  // 3+3+3+5+5
    }

    @Test
    void FullHouse_카테고리는_패턴이_아니면_0점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(3), new Dice(3), new Dice(3),
                new Dice(3), new Dice(5)
        ));

        //when
        int score = Category.FULL_HOUSE.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(0);
    }

    @Test
    void SmallStraight_카테고리는_연속_4개면_15점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(3),
                new Dice(4), new Dice(6)
        ));

        //when
        int score = Category.SMALL_STRAIGHT.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(15);
    }

    @Test
    void SmallStraight_카테고리는_연속이_없으면_0점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(4),
                new Dice(5), new Dice(6)
        ));

        //when
        int score = Category.SMALL_STRAIGHT.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(0);
    }

    @Test
    void LargeStraight_카테고리는_연속_5개면_30점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(3),
                new Dice(4), new Dice(5)
        ));

        //when
        int score = Category.LARGE_STRAIGHT.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(30);
    }

    @Test
    void LargeStraight_카테고리는_연속이_없으면_0점이다() {
        //given
        Dices dices = new Dices(List.of(
                new Dice(1), new Dice(2), new Dice(3),
                new Dice(5), new Dice(6)
        ));

        //when
        int score = Category.LARGE_STRAIGHT.calculateScore(dices);

        //then
        assertThat(score).isEqualTo(0);
    }
}
