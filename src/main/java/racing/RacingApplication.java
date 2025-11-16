package racing;

import racing.controller.RacingController;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(inputView, outputView);

        controller.run();
    }
}
