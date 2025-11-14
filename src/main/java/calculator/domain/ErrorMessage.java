package calculator.domain;

public enum ErrorMessage {
    NULL_INPUT("입력값이 null입니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자 형식이 잘못되었습니다."),
    INVALID_NUMBER("숫자가 아닌 값이 포함 되어 있습니다: %s"),
    NEGATIVE_NUMBER("음수는 입력할 수 없습니다: %d");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
