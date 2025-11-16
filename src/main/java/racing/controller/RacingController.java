package racing.controller;

import java.util.List;
import racing.domain.Cars;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        int raceCount = inputView.readRaceCount();

        Cars cars = new Cars(carNames);

        outputView.printResultHeader();

        for (int i = 0; i < raceCount; i++) {
            cars.moveAll();
            outputView.printRoundResult(cars.getCars());
        }

        outputView.printWinners(cars.getWinners());
    }
}
