// Concrete Class 8: cash payment
public class CashPayment extends Payment {
    protected String receivedBy;
    protected double cashReceived;

    public CashPayment(String paymentId, Reservation reservation, String receivedBy) {
        super(paymentId, reservation);
        this.receivedBy = receivedBy;
        this.cashReceived = 0;
    }

    @Override
    public boolean processPayment(double payAmount) {
        if (payAmount <= 0) {
            System.out.println("  Invalid cash amount.");
            return false;
        }
        cashReceived += payAmount;
        amountPaid += Math.min(payAmount, getOutstandingBalance() + (payAmount - payAmount));
        amountPaid = Math.min(cashReceived, amount);
        status = (amountPaid >= amount) ? "Paid" : "Partial";
        double change = cashReceived - amount;
        System.out.println("  Cash received: $" + String.format("%.2f", payAmount)
                + " by " + receivedBy + " → " + status);
        if (change > 0) {
            System.out.println("  Change given: $" + String.format("%.2f", change));
        }
        return true;
    }

    @Override
    public String getPaymentMethod() { return "Cash"; }
}
