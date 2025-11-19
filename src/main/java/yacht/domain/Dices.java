package yacht.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dices {
    private static final int DICE_COUNT = 5;


    private final List<Dice> dices;

    public Dices(List<Dice> dices) {
        validateSize(dices);
        this.dices = new ArrayList<>(dices);
    }

    private void validateSize(List<Dice> dices) {
        if (dices.size() != DICE_COUNT) {
            throw new IllegalArgumentException(
                    "주사위는 " + DICE_COUNT + "개여야 합니다."
            );
        }
    }

    public boolean isYacht() {
        for (int value = 1; value <= 6; value++) {
            if (countValue(value) == 5) {
                return true;
            }
        }
        return false;
    }

    public  int getFourOfAKindValue() {
        for (int value = 1; value <= 6; value++) {
            if (countValue(value) >= 4) {
                return value;
            }
        }
        return 0;
    }

    public static Dices roll() {
        List<Dice> diceList = new ArrayList<>();
        for (int i = 0; i < DICE_COUNT; i++) {
            diceList.add(Dice.roll());
        }
        return new Dices(diceList);
    }

    public void rerollSelected(List<Integer> positions) {
        for (int position : positions) {
            int index = position - 1;
            validatePosition(index);
            dices.set(index, Dice.roll());
        }
    }

    private void validatePosition(int index) {
        if (index < 0 || index >= DICE_COUNT) {
            throw new IllegalArgumentException(
                    "주사위 위치는 0부터 " + (DICE_COUNT - 1) + " 사이여야 합니다."
            );
        }
    }

    public int sumAll() {
        return dices.stream()
                .mapToInt(Dice::getValue)
                .sum();
    }

    public int countValue(int target) {
        return (int) dices.stream()
                .filter(dice -> dice.isSameValue(target))
                .count();
    }

    public List<Integer> getValues() {
        return dices.stream()
                .map(Dice::getValue)
                .collect(Collectors.toList());
    }

    public boolean isFullHouse() {
        boolean hasThree = false;
        boolean hasTwo = false;

        for (int value = 1; value <= 6; value++) {
            int count = countValue(value);
            if (count == 3) {
                hasThree = true;
            }
            if (count == 2) {
                hasTwo = true;
            }
        }
        return hasThree && hasTwo;
    }

    public boolean isSmallStraight() {
        if (hasValue(1) && hasValue(2) && hasValue(3) && hasValue(4)) {
            return true;
        }

        if (hasValue(2) && hasValue(3) && hasValue(4) && hasValue(5)) {
            return true;
        }

        if (hasValue(3) && hasValue(4) && hasValue(5) && hasValue(6)) {
            return true;
        }
        return false;
    }

    public boolean isLargeStraight() {
        if (hasValue(1) && hasValue(2) && hasValue(3) &&
                hasValue(4) && hasValue(5)) {
            return true;
        }

        if (hasValue(2) && hasValue(3) && hasValue(4) &&
                hasValue(5) && hasValue(6)) {
            return true;
        }
        return false;
    }

    private boolean hasValue(int value) {
        return countValue(value) > 0;
    }
}
