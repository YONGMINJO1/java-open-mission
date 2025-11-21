package yacht.domain;

public enum Category {
    ONES("Ones", 1),
    TWOS("Twos", 2),
    THREES("Threes", 3),
    FOURS("Fours", 4),
    FIVES("Fives", 5),
    SIXES("Sixes", 6),
    FOUR_OF_A_KIND("Four of a Kind", 0),
    FULL_HOUSE("Full House", 0),
    SMALL_STRAIGHT("Small Straight", 0),
    LARGE_STRAIGHT("Large Straight", 0),
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
            return calculateChoice(dices);
        }
        if (this == FOUR_OF_A_KIND) {
            return calculateFourOfAKind(dices);
        }
        if (this == FULL_HOUSE) {
            return calculateFullHouse(dices);
        }
        if (this == SMALL_STRAIGHT) {
            return calculateSmallStraight(dices);
        }
        if (this == LARGE_STRAIGHT) {
            return calculateLargeStraight(dices);
        }
        if (this == YACHT) {
            return calculateYacht(dices);
        }
        return calculateNumberCategory(dices);
    }

    private int calculateChoice(Dices dices) {
        return dices.sumAll();
    }

    private int calculateFourOfAKind(Dices dices) {
        int value = dices.getFourOfAKindValue();
        if (value == 0) {
            return 0;
        }
        return dices.sumAll();
    }

    private int calculateFullHouse(Dices dices) {
        if (dices.isFullHouse()) {
            return dices.sumAll();
        }
        return 0;
    }

    private int calculateSmallStraight(Dices dices) {
        if (dices.isSmallStraight()) {
            return 15;
        }
        return 0;
    }

    private int calculateLargeStraight(Dices dices) {
        if (dices.isLargeStraight()) {
            return 30;
        }
        return 0;
    }

    private int calculateYacht(Dices dices) {
        if (dices.isYacht()) {
            return 50;
        }
        return 0;
    }

    private int calculateNumberCategory(Dices dices) {
        return dices.countValue(targetNumber) * targetNumber;
    }

    public String getName() {
        return name;
    }
}
