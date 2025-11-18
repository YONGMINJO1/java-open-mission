package yacht.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dices {
    private final List<Dice> dices;

    public Dices(List<Dice> dices) {
        this.dices = new ArrayList<>(dices);
    }

    public List<Integer> getValues() {
        return dices.stream()
                .map(Dice::getValue)
                .collect(Collectors.toList());
    }
}
