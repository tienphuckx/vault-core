package models;

import commons.AccountCyy;

public class Account {
    private String accountNumber;
    private Double amount = 0.0;
    private User user;
    private String bankCode;
    private String accountType;
    private String bankBranchCode;
    private AccountCyy ccy;

    public Account(String accountNumber, String accountType, String bankCode, String bankBranchCode, AccountCyy ccy, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
        this.accountType = accountType;
        this.bankCode = bankCode;
        this.bankBranchCode = bankBranchCode;
        this.ccy = ccy;
    }

    public AccountCyy getCcy() {
        return ccy;
    }

    public void setCcy(AccountCyy ccy) {
        this.ccy = ccy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
