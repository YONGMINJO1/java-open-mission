package yacht.domain;

import java.util.EnumMap;
import java.util.Map;

public class ScoreBoard {
    private final Map<Category, Integer> scores;

    public ScoreBoard() {
        this.scores = new EnumMap<>(Category.class);
        initializeScores();
    }

    private void initializeScores() {
        for (Category category : Category.values()) {
            scores.put(category, 0);
        }
    }

    public void recordScore(Category category, int score) {
        scores.put(category, score);
    }

    public Map<Category, Integer> getScores() {
        return new EnumMap<>(scores);
    }
}
