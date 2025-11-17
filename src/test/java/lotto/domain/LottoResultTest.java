package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void 등수별_개수를_저장할_수_있다() {
        //given
        LottoResult result = new LottoResult();

        //when
        result.addRank(LottoRank.FOURTH);
        result.addRank(LottoRank.FOURTH);
        result.addRank(LottoRank.FIFTH);

        //then
        assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(result.getCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(0);
    }

    @Test
    void null이면_개수를_증가시키지_않는다() {
        //given
        LottoResult result = new LottoResult();

        //when
        result.addRank(null);
        result.addRank(null);

        //then
        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(0);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(0);
    }

    @Test
    void 총_상금을_계산할_수_있다() {
        //given
        LottoResult result = new LottoResult();
        result.addRank(LottoRank.FIFTH);
        result.addRank(LottoRank.FOURTH);
        result.addRank(LottoRank.FOURTH);

        //when
        long totalPrize = result.getTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(105_000);
    }

    @Test
    void 수익률을_계산할_수_있다() {
        //given
        LottoResult result = new LottoResult();
        result.addRank(LottoRank.FIFTH);
        result.addRank(LottoRank.FOURTH);
        result.addRank(LottoRank.FOURTH);

        int purchaseAmount = 8000;

        //when
        double profitRate = result.getProfitRate(purchaseAmount);

        //then
        assertThat(profitRate).isEqualTo(1312.5);
    }

    @Test
    void 당첨되지_앉으면_수익률은_0이다() {
        //given
        LottoResult result = new LottoResult();

        int purchaseAmount = 8000;

        //when
        double profitRate = result.getProfitRate(purchaseAmount);

        //then
        assertThat(profitRate).isEqualTo(0.0);
    }
}
