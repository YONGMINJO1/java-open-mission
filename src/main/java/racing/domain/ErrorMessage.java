package racing.domain;

public enum ErrorMessage {
    NULL_OR_BLANK_NAME("자동차 이름은 필수입니다."),
    NAME_LENGTH_EXCEEDED("자동차 이름은 5자 이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
