package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoGenerator lottoGenerator = new LottoGenerator();

            LottoController controller = new LottoController(inputView, outputView, lottoGenerator);
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
