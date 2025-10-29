package week08.milano.id.ac.umn.Tutorial;

public class BankTransferPayment extends Payment {
    private String bankAccount;

    public BankTransferPayment(double amount, String bankAccount) {
        super(amount);
        this.bankAccount = bankAccount;
    }

    @Override
    void processPayment() {
        System.out.println("Processing bank transfer payment of $" + amount + " for bank account " + bankAccount);
    }
}
