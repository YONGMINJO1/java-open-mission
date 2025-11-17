package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        Lottos lottos = purchaseLottos();
        WinningNumbers winningNumbers = readWinningNumbers();
        LottoResult result = checkLottos(lottos, winningNumbers);
        printResult(result, lottos.size());
    }

    private Lottos purchaseLottos() {
        int amount = inputView.readPurchaseAmount();
        int count = amount / 1000;

        Lottos lottos = generateLottos(count);
        outputView.printLottos(lottos.getLottos());

        return lottos;
    }

    private Lottos generateLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(lottoGenerator.generate());
        }
        return new Lottos(lottoList);
    }

    private WinningNumbers readWinningNumbers() {
        List<Integer> numbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        return new WinningNumbers(numbers, bonusNumber);
    }

    private LottoResult checkLottos(Lottos lottos, WinningNumbers winningNumbers) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos.getLottos()) {
            LottoRank rank = winningNumbers.check(lotto);
            result.addRank(rank);
        }

        return result;
    }

    private void printResult(LottoResult result, int lottoCount) {
        outputView.printStatistics(result);

        int purchaseAmount = lottoCount * 1000;
        double profitRate = result.getProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
