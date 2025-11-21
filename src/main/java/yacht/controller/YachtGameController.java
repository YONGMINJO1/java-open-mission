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
        if (category == null) {
            OutputView.printGameQuit();
            return;
        }
        recordScore(category, dices);
    }

    private void selectedDiceReroll(Dices dices) {
        int rerollCount = 0;

        while (rerollCount < MAX_REROLL_COUNT) {
            if (!askReroll()) {
                break;
            }
            boolean executed = performReroll(dices);
            if (executed) {
                rerollCount++;
            }
        }
    }

    private boolean askReroll() {
        while (true) {
            try {
                return InputView.readRerollChoice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean performReroll(Dices dices) {
        while (true) {
            try {
                List<Integer> selection = InputView.readDiceSelection();

                if (selection.isEmpty()) {
                    OutputView.printRerollCancel();
                    return false;
                }
                dices.rerollSelected(selection);
                OutputView.printRerollStart();
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

                if (number == 0) {
                    return null;
                }
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
