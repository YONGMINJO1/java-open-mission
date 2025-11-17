package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    void 일등은_6개_일치() {
        //given
        int matchCount = 6;
        boolean bonusMatch = false;

        //when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        //then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
        assertThat(rank.getPrizeMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    void 이등은_5개_일치_보너스_일치() {
        //given
        int matchCount = 5;
        boolean bonusMatch = true;

        //when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        //then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
        assertThat(rank.getPrizeMoney()).isEqualTo(30_000_000);
    }

    @Test
    void 삼등은_5개_일치() {
        //given
        int matchCount = 5;
        boolean bonusMatch = false;

        //when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        //then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 일치_개수가_2개_이하면_null() {
        //given
        int matchCount = 2;
        boolean bonusMatch = false;

        //when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        //then
        assertThat(rank).isNull();
    }
}
