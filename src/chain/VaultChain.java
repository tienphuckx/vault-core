package chain;
import chain.node.VaultNode;
import java.util.logging.Logger;
public class VaultChain {
    Logger logger = Logger.getLogger(getClass().getName());
    private VaultNode head;
    private VaultNode tail;

    public VaultChain() {
        this.head = null;
        this.tail = null;
    }

    public VaultChain(VaultNode newNode) {
        if(tail == null) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.setParent(this.tail);
            tail.setChild(newNode);
            tail = newNode;
        }
    }


    public VaultChain addNewNodeAtLast(VaultNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.setParent(tail);
            tail.setChild(newNode);
            tail = newNode;
        }

        return this;
    }

    public boolean validateChain() {
        VaultNode current = head;
        while (current != null && current.getChild() != null) {
            if (!current.getChild().getParent().equals(current)) {
                return false; // Parent-child link is broken
            }
            if (!current.getHash().equals(current.getChild().getParent().getHash())) {
                return false; // Hash consistency check
            }
            current = current.getChild();
        }
        return true;
    }

    public void listAllNodes() {
        VaultNode current = head;
        while (current != null) {
            printNodeData(current);
            current = current.getChild();
        }
    }

    public void findNodeByHash(String hash) {
        VaultNode current = head;
        while (current != null) {
            if (current.getHash().equals(hash)) {
                System.out.println(current.getHash());
                return;
            }
            current = current.getChild();
        }
    }

    private void printNodeData(VaultNode current) {
        System.out.println(" ____________________________________________________________________________________________________________________");
        System.out.println("| Transaction Id:                     " + current.getTransaction().getTransactionID());
        System.out.println("| Account:                            " + current.getTransaction().getPrimaryAccountNumber());
        System.out.println("| Transaction type:                   " + current.getTransaction().getTransactionType());
        System.out.println("| Amount:                             " + current.displayAmountChange(current.getTransaction().getCcy().toString()));
        System.out.println("| Message:                            " + current.getTransaction().getTransactionMessage());
        System.out.println("| Hash:                               " + current.getHash());
        System.out.println("| TIME:                               " + current.getTransaction().getTimestamp());
    }

    public void findTransactionsByTransId(String transactionID) {
        VaultNode current = head;
        while (current != null) {
            if (current.getTransaction().getTransactionID().equals(transactionID)) {
                printNodeData(current);
            }
            current = current.getChild();
        }
    }
}


