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

    public static Dices roll() {
        List<Dice> diceList = new ArrayList<>();
        for (int i = 0; i < DICE_COUNT; i++) {
            diceList.add(Dice.roll());
        }
        return new Dices(diceList);
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
}
