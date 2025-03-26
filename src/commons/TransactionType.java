package commons;

public enum TransactionType {
    SEND(1, "SEND"),
    RECEIVED(2, "RECEIVED"),
    DEPOSIT(3, "DEPOSIT"),
    WITHDRAW(4, "WITHDRAW"),
    ;

    private final int code;
    private final String description;

    // Constructor
    TransactionType(int code, String description) {
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

    public static TransactionType fromCode(int code) {
        for (TransactionType type : TransactionType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
