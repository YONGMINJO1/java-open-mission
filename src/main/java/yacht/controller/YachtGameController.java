package yacht.controller;

import java.util.List;
import yacht.domain.Category;
import yacht.domain.Dices;
import yacht.domain.ScoreBoard;
import yacht.view.InputView;
import yacht.view.OutputView;

public class YachtGameController {
    private static final int MAX_REROLL_COUNT = 2;

    private final ScoreBoard scoreBoard;

    public YachtGameController() {
        this.scoreBoard = new ScoreBoard();
    }

    public void run() {
        OutputView.printGameStart();
        playAllRounds();
        finishGame();
    }

    private void playAllRounds() {
        while (!scoreBoard.isGameOver()) {
            playRound();
        }
    }

    private void playRound() {
        Dices dices = throwDiceAndShow();
        selectedDiceReroll(dices);
        Category category = selectCategory();
        recordScore(category, dices);
    }

    private void selectedDiceReroll(Dices dices) {
        int rerollCount = 0;

        while (rerollCount < MAX_REROLL_COUNT) {
            if (!askReroll()) {
                break;
            }
            boolean success = performReroll(dices);
            if (success) {
                rerollCount++;
            }
        }
    }

    private boolean askReroll() {
        try {
            return InputView.readRerollChoice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean performReroll(Dices dices) {
        while (true) {
            try {
                List<Integer> selection = InputView.readDiceSelection();
                dices.rerollSelected(selection);
                System.out.println();
                System.out.println("주사위를 다시 굴립니다.");
                OutputView.printDices(dices.getValues());
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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

    private Category selectCategory() {
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
