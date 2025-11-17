package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoRank check(Lotto lotto) {
        int matchCount = countMatches(lotto);
        boolean bonusMatch = hasBonusMatch(lotto);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }

    public boolean hasBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int countMatches(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbersList = winningLotto.getNumbers();

        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbersList.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(bonusNumber);
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateBonusDuplicate(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
