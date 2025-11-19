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
        testRerollInput(dices);
        Category category = selectCategory();
        recordScore(category, dices);
    }

    private void testRerollInput(Dices dices) {
        try {
            boolean reroll = InputView.readRerollChoice();

            if (reroll) {
                System.out.println("✅ 재굴림을 선택했습니다!");

                List<Integer> selection = InputView.readDiceSelection();
                System.out.println("✅ 선택한 주사위: " + selection);

                System.out.println("현재 주사위: " + dices.getValues());

            } else {
                System.out.println("✅ 재굴림하지 않습니다.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("❌ 오류 발생: " + e.getMessage());

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
