package racing.domain;

public class Car {
    private static final int MAM_NAME_LENGTH = 5;

    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void move() {
        position++;
    }
}
