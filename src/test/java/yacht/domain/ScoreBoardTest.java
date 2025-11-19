package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    @Test
    void 점수를_기록할_수_있다() {
        //given
        ScoreBoard scoreBoard = new ScoreBoard();

        //when
        scoreBoard.recordScore(Category.ONES, 2);

        //then
        Map<Category, Integer> scores = scoreBoard.getScores();
        assertThat(scores.get(Category.ONES)).isEqualTo(2);
    }

    @Test
    void 이미_사용한_카테고리는_다시_사용할_수_없다() {
        //given
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.recordScore(Category.ONES, 2);

        //when & then
        assertThatThrownBy(() -> scoreBoard.recordScore(Category.ONES, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 사용");
    }

    @Test
    void 모든_카테고리를_사용하면_게임이_종료된다() {
        //given
        ScoreBoard scoreBoard = new ScoreBoard();

        //when
        scoreBoard.recordScore(Category.ONES, 2);
        scoreBoard.recordScore(Category.TWOS, 4);
        scoreBoard.recordScore(Category.THREES, 6);
        scoreBoard.recordScore(Category.FOURS, 4);
        scoreBoard.recordScore(Category.FIVES, 5);
        scoreBoard.recordScore(Category.SIXES, 6);
        scoreBoard.recordScore(Category.FOUR_OF_A_KIND, 12);
        scoreBoard.recordScore(Category.CHOICE, 15);

        //then
        assertThat(scoreBoard.isGameOver()).isFalse();

        //when
        scoreBoard.recordScore(Category.YACHT, 50);

        //then
        assertThat(scoreBoard.isGameOver()).isTrue();
    }

    @Test
    void 총점을_계산할_수_있다() {
        //given
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.recordScore(Category.ONES, 2);
        scoreBoard.recordScore(Category.TWOS, 4);
        scoreBoard.recordScore(Category.THREES, 6);
        scoreBoard.recordScore(Category.CHOICE, 15);

        //when
        int totalScore = scoreBoard.getTotalScore();

        //then
        assertThat(totalScore).isEqualTo(27);
    }
}
