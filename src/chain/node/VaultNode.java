package chain.node;
import commons.TransactionAction;
import models.Transaction;

import java.util.UUID;

public class VaultNode {

    private VaultNode parent;
    private VaultNode child;
    private Transaction transaction;
    private String hash;

    public void initVaultNode(Transaction transaction) {
        this.transaction = transaction;
        this.parent = this;
        this.child = null;
        this.hash = generateHash(transaction);
    }

    public VaultNode(Transaction transaction) {
        this.transaction = transaction;
        this.hash = generateHash(transaction);
    }

    private String generateHash(Transaction transaction) {
        String input = transaction.getTransactionIdAsString();
        if (parent != null) {
            input += parent.getHash();
        } else {
            input += transaction.getTransactionID();
        }
        return UUID.randomUUID().toString() + input;
    }

    public String displayAmountChange(String ccy) {
        if(this.transaction.getAction().equals(TransactionAction.PLUS)) {
            return "+ " + this.transaction.getAmount() + " " + ccy;
        } else {
            return "- " + this.transaction.getAmount() + " " + ccy;
        }
    }

    // Getters and Setters
    public String getHash() {
        return hash;
    }

    public VaultNode getParent() {
        return parent;
    }

    public VaultNode getChild() {
        return child;
    }

    public void setParent(VaultNode parent) {
        this.parent = parent;
    }

    public void setChild(VaultNode child) {
        this.child = child;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}

