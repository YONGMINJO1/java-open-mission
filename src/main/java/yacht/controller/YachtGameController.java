package yacht.controller;

import java.util.List;
import yacht.domain.Category;
import yacht.domain.Dices;
import yacht.domain.ScoreBoard;
import yacht.view.InputView;
import yacht.view.OutputView;

public class YachtGameController {
    private final ScoreBoard scoreBoard;

    public YachtGameController() {
        this.scoreBoard = new ScoreBoard();
    }

    public void run() {
        OutputView.printGameStart();
        playRound();
        finishGame();
    }

    private void playAllRound() {
        while (!scoreBoard.isGameOver()) {
            playRound();
        }
    }

    private void playRound() {
        Dices dices = throwDiceAndShow();
        Category category = selsctCategory();
        recordScore(category, dices);
    }

    private void finishGame() {
        int totalScore = scoreBoard.getTotalScore();
        OutputView.printFinalScore(totalScore);
    }

    private Dices throwDiceAndShow() {
        InputView.throwDice();
        Dices dices = Dices.roll();
        OutputView.printDices(dices.getValues());
        return dices;
    }

    private Category selsctCategory() {
        List<Category> availableCategories = scoreBoard.getAvailableCategories();
        OutputView.printCategories(availableCategories);

        while (true) {
            try {
                int number = InputView.readCategoryNumber();
                validateCategoryNumber(number, availableCategories.size());
                return availableCategories.get(number - 1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateCategoryNumber(int number, int maxSize) {
        if (number < 1 || number > maxSize) {
            throw new IllegalArgumentException(
                    "[ERROR] 1부터 " + maxSize + " 사이의 숫자를 입력해주세요."
            );
        }
    }

    private void recordScore(Category category, Dices dices) {
        int score = category.calculateScore(dices);
        scoreBoard.recordScore(category, score);
        OutputView.printScore(category, score);
    }
}
