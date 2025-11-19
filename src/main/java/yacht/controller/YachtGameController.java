package yacht.controller;

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
    }

    private void playRound() {
        Dices dices = throwDiceAndShow();
        Category category = selsctCategory();
        recordScore(category, dices);
    }

    private Dices throwDiceAndShow() {
        InputView.throwDice();
        Dices dices = Dices.roll();
        OutputView.printDices(dices.getValues());
        return dices;
    }

    private Category selsctCategory() {
        return Category.ONES;
    }

    private void recordScore(Category category, Dices dices) {
        int score = category.calculateScore(dices);
        scoreBoard.recordScore(category, score);
        OutputView.printScore(category, score);
    }
}
