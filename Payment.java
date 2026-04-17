// Abstract Class 4: base for all payment methods
public abstract class Payment implements Payable {
    protected String paymentId;
    protected double amount;
    protected double amountPaid;
    protected String status; // "Pending", "Paid", "Partial"
    protected Reservation reservation;

    public Payment(String paymentId, Reservation reservation) {
        this.paymentId = paymentId;
        this.reservation = reservation;
        this.amount = reservation.totalCost;
        this.amountPaid = 0;
        this.status = "Pending";
    }

    public abstract String getPaymentMethod();

    @Override
    public double getOutstandingBalance() {
        return amount - amountPaid;
    }

    @Override
    public void printReceipt() {
        System.out.println("  ── Receipt ──────────────────────");
        System.out.println("  Payment ID : " + paymentId);
        System.out.println("  Method     : " + getPaymentMethod());
        System.out.println("  Reservation: " + reservation.reservationId);
        System.out.println("  Total Due  : $" + String.format("%.2f", amount));
        System.out.println("  Paid       : $" + String.format("%.2f", amountPaid));
        System.out.println("  Balance    : $" + String.format("%.2f", getOutstandingBalance()));
        System.out.println("  Status     : " + status);
        System.out.println("  ─────────────────────────────────");
    }

    @Override
    public String toString() {
        return "[" + getPaymentMethod() + "] " + paymentId + " | $"
                + String.format("%.2f", amountPaid) + "/" + String.format("%.2f", amount)
                + " | " + status;
    }
}
