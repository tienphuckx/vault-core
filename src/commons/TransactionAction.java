package commons;

public enum TransactionAction {
    PLUS(1, "+"),
    MINUS(2, "-");

    private final int code;
    private final String description;

    // Constructor
    TransactionAction(int code, String description) {
        this.code = code;
        this.description = description;
    }

    // Getter methods
    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TransactionAction fromCode(int code) {
        for (TransactionAction type : TransactionAction.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
