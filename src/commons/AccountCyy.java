package commons;

public enum AccountCyy {
    VND("VND"),  // Vietnamese Dong
    USD("USD");  // United States Dollar

    private final String currencyCode;

    // Constructor to associate each enum with a currency code
    AccountCyy(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    // Getter method to retrieve the currency code
    public String getCurrencyCode() {
        return currencyCode;
    }
}
