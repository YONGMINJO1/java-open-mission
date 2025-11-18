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
}
