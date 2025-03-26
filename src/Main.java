import chain.VaultChain;
import chain.node.VaultNode;
import commons.AccountCyy;
import commons.TransactionAction;
import commons.TransactionType;
import models.Account;
import models.Transaction;
import models.User;

public class Main {
    public static void main(String[] args) {

        User johnWick = new User(1, "John Wick", "New York");
        Account account = new Account("01930109293 ", "CUR", "HDB", "HCM001" , AccountCyy.VND ,johnWick);
        Transaction transaction = new Transaction(account, TransactionType.DEPOSIT, TransactionAction.PLUS, 99.0, "John Wick deposit");
        VaultNode vaultNode = new VaultNode(transaction);
        vaultNode.initVaultNode(transaction);

        User phuc = new User(2, "PhucNguyen", "HCM");
        Account phucAccount = new Account("01920193123 ", "CUR", "VCB", "HCM002", AccountCyy.USD, phuc);
        Transaction phucTransaction = new Transaction(phucAccount, TransactionType.DEPOSIT, TransactionAction.PLUS, 97.0, "PhucNguyen deposit");
        VaultNode phucNode = new VaultNode(phucTransaction);
        phucNode.initVaultNode(phucTransaction);

        User toLam = new User(3, "To Lam", "Viet Nam");
        Account toLamAccount = new Account("091091204", "CUR", "VN", "HANOI", AccountCyy.VND, toLam);
        Transaction toLamToPhucTransaction = new Transaction(toLamAccount, TransactionType.SEND, TransactionAction.MINUS, 10000.00, "VINH DANH DONG CHI PHUC");
        VaultNode toLamNode = new VaultNode(toLamToPhucTransaction);

        User tienPhuc = new User(3, "Nguyen Tien Phuc", "Viet Nam");
        Account tienPhucAccount = new Account("979796765867", "CUR", "VN", "HATINH", AccountCyy.VND, tienPhuc);
        Transaction tienPhucTrans = new Transaction(toLamToPhucTransaction.getTransactionID(), tienPhucAccount, TransactionType.RECEIVED, TransactionAction.PLUS, toLamToPhucTransaction.getAmount(), toLamToPhucTransaction.getTransactionMessage());
        VaultNode tienPhucNhanTIen = new VaultNode(tienPhucTrans);

        VaultChain vc = new VaultChain(vaultNode);
        vc.addNewNodeAtLast(phucNode);
        vc.addNewNodeAtLast(toLamNode);
        vc.addNewNodeAtLast(tienPhucNhanTIen);
        /*vc.listAllNodes();*/

        vc.findTransactionsByTransId(toLamToPhucTransaction.getTransactionID());

    }
}
