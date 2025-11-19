package yacht.domain;

public enum Category {
    ONES("Ones", 1),
    TWOS("Twos", 2),
    THREES("Threes", 3),
    FOURS("Fours", 4),
    FIVES("Fives", 5),
    SIXES("Sixes", 6),
    FOUR_OF_A_KIND("Four of a Kind", 0),
    YACHT("Yacht", 0),
    CHOICE("Choice", 0);

    private final String name;
    private final int targetNumber;

    Category(String name, int targetNumber) {
        this.name = name;
        this.targetNumber = targetNumber;
    }

    public int calculateScore(Dices dices) {
        if (this == CHOICE) {
            return dices.sumAll();
        }
        if (this == FOUR_OF_A_KIND) {
            int value = dices.getFourOfAKindValue();
            if (value == 0) {
                return 0;
            }
            return dices.sumAll();
        }
        if (this == YACHT) {
            if (dices.isYacht()) {
                return 50;
            }
            return 0;
        }
        return dices.countValue(targetNumber) * targetNumber;
    }

    public String getName() {
        return name;
    }
}
