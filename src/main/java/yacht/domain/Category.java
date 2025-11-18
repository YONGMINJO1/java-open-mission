package yacht.domain;

public enum Category {
    ONES("Ones"),
    TWOS("Twos"),
    THREES("Threes"),
    CHOICE("Choice");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
