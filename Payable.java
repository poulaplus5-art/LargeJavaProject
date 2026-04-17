// Interface 3: anything that involves payment
public interface Payable {
    boolean processPayment(double amount);
    double getOutstandingBalance();
    void printReceipt();
}
