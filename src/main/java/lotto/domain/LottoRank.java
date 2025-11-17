package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean requireBonus;
    private final int prizeMoney;

    LottoRank(int matchCount, boolean requireBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.requireBonus = requireBonus;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matches(matchCount, bonusMatch)) {
                return rank;
            }
        }
        return null;
    }

    private boolean matches(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount && this.requireBonus == bonusMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
