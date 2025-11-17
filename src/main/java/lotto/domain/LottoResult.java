package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this.result = initializeResult();
    }

    private Map<LottoRank, Integer> initializeResult() {
        Map<LottoRank, Integer> map = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            map.put(rank, 0);
        }
        return map;
    }

    public void addRank(LottoRank rank) {
        if (rank == null) {
            return;
        }
        result.put(rank, result.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return result.get(rank);
    }
}
