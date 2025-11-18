package yacht.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;

    private final int value;

    public Dice(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "주사위 값은 " + MIN_VALUE + "부터 " + MAX_VALUE + " 사이여야 합니다."
            );
        }
    }

    public static Dice roll() {
        return new Dice(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
    }

    public boolean isSameValue(int target) {
        return this.value == target;
    }

    public int getValue() {
        return value;
    }
}
