package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
