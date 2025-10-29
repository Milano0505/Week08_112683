package week08.milano.id.ac.umn.Tutorial;

public class Main {
    public static void main(String[] args) {

        // Membuat objek untuk setiap metode pembayaran
        Payment creditCardPayment = new CreditCardPayment(100.0,"1234-5678-9012-3456");
        Payment bankTransferPayment = new BankTransferPayment(300.0,"9876543210");

        // Memproses setiap pembayaran
        creditCardPayment.paymentDetails();
        creditCardPayment.processPayment();
        bankTransferPayment.paymentDetails();
        bankTransferPayment.processPayment();
    }
}
