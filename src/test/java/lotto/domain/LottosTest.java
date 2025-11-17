package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또_여러_장을_생성할_수_있다() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> lottoList = List.of(lotto1, lotto2);

        //when
        Lottos lottos = new Lottos(lottoList);

        //then
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    void 로또_목록을_조회할_수_있다() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> lottoList = List.of(lotto1, lotto2);

        //when
        Lottos lottos = new Lottos(lottoList);

        //then
        assertThat(lottos.getLottos()).hasSize(2);
        assertThat(lottos.getLottos()).contains(lotto1, lotto2);
    }
}
