package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private static final int LOOTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_SIZE = 6;

    public Lotto generate() {
        List<Integer> numbers = generateRandomNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOOTO_START, LOTTO_END, LOTTO_SIZE);
    }
}
