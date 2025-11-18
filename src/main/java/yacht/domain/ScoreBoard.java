package yacht.domain;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class ScoreBoard {
    private final Map<Category, Integer> scores;
    private final Set<Category> usedCategories;

    public ScoreBoard() {
        this.scores = new EnumMap<>(Category.class);
        this.usedCategories = EnumSet.noneOf(Category.class);
        initializeScores();
    }

    private void initializeScores() {
        for (Category category : Category.values()) {
            scores.put(category, 0);
        }
    }

    public void recordScore(Category category, int score) {
        validateNotUsed(category);
        scores.put(category, score);
        usedCategories.add(category);
    }

    private void validateNotUsed(Category category) {
        if (usedCategories.contains(category)) {
            throw new IllegalArgumentException("이미 사용한 카테고리입니다.");
        }
    }

    public boolean isGameOver() {
        return usedCategories.size() == Category.values().length;
    }

    public Map<Category, Integer> getScores() {
        return new EnumMap<>(scores);
    }
}
