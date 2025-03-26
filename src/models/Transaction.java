package models;
import commons.AccountCyy;
import commons.TransactionAction;
import commons.TransactionType;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionID;
    private TransactionType transactionType; /** DEPOSIT | WITHDRAWAL | SEND | RECEIVE */
    private TransactionAction action; /** PLUS | MINUS */
    private Double amount;
    private String primaryAccountNumber;
    private String primaryAccountBankCode;
    private String primaryAccountBankBranchCode;
    private AccountCyy ccy;
    private String transactionMessage;
    private Date timestamp = new Date();

    public Transaction(Account account, TransactionType transactionType, TransactionAction action, double amount, String transactionMessage) {
        this.transactionID =UUID.randomUUID().toString();
        this.transactionType = transactionType;
        this.action = action;
        this.amount = amount;
        this.primaryAccountNumber = account.getAccountNumber();
        this.primaryAccountBankCode = account.getBankCode();
        this.primaryAccountBankBranchCode = account.getBankBranchCode();
        this.ccy = account.getCcy();
        this.transactionMessage = transactionMessage;
    }

    public Transaction(String transactionID ,Account account, TransactionType transactionType, TransactionAction action, double amount, String transactionMessage) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.action = action;
        this.amount = amount;
        this.primaryAccountNumber = account.getAccountNumber();
        this.primaryAccountBankCode = account.getBankCode();
        this.primaryAccountBankBranchCode = account.getBankBranchCode();
        this.ccy = account.getCcy();
        this.transactionMessage = transactionMessage;
    }

    public String getTransactionMessage() {
        return transactionMessage;
    }

    public void setTransactionMessage(String transactionMessage) {
        this.transactionMessage = transactionMessage;
    }

    public AccountCyy getCcy() {
        return ccy;
    }

    public void setCcy(AccountCyy ccy) {
        this.ccy = ccy;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getTransactionIdAsString() {
        return String.valueOf(transactionID);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionAction getAction() {
        return action;
    }

    public void setAction(TransactionAction action) {
        this.action = action;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(String primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber;
    }

    public String getPrimaryAccountBankCode() {
        return primaryAccountBankCode;
    }

    public void setPrimaryAccountBankCode(String primaryAccountBankCode) {
        this.primaryAccountBankCode = primaryAccountBankCode;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getPrimaryAccountBankBranchCode() {
        return primaryAccountBankBranchCode;
    }

    public void setPrimaryAccountBankBranchCode(String primaryAccountBankBranchCode) {
        this.primaryAccountBankBranchCode = primaryAccountBankBranchCode;
    }
}
