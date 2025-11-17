package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";
    private static final String MATCH_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String MATCH_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(LOTTO_COUNT_FORMAT + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(LottoResult lottoResult) {
        System.out.println();
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);

        printRankStatistic(LottoRank.FIFTH, lottoResult);
        printRankStatistic(LottoRank.FOURTH, lottoResult);
        printRankStatistic(LottoRank.THIRD, lottoResult);
        printSecondRank(lottoResult);
        printRankStatistic(LottoRank.FIRST, lottoResult);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT + "%n", profitRate);
    }

    private void printRankStatistic(LottoRank rank, LottoResult lottoResult) {
        int matchCount = rank.getMatchCount();
        int prizeMoney = rank.getPrizeMoney();
        int count = lottoResult.getCount(rank);

        System.out.printf(MATCH_FORMAT + "%n", matchCount, prizeMoney, count);
    }

    private void printSecondRank(LottoResult lottoResult) {
        int matchCount = LottoRank.SECOND.getMatchCount();
        int prizeMoney = LottoRank.SECOND.getPrizeMoney();
        int count = lottoResult.getCount(LottoRank.SECOND);

        System.out.printf(MATCH_WITH_BONUS_FORMAT + "%n", matchCount, prizeMoney, count);
    }
}
