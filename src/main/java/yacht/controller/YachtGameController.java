package yacht.controller;

import yacht.domain.ScoreBoard;
import yacht.view.OutputView;

public class YachtGameController {
    private final ScoreBoard scoreBoard;

    public YachtGameController() {
        this.scoreBoard = new ScoreBoard();
    }

    public void run() {
        OutputView.printGameStart();
    }
}
