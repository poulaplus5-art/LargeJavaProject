// Concrete Class 7: credit card payment
public class CreditCardPayment extends Payment {
    protected String cardLastFour;
    protected String cardHolderName;
    protected String cardNetwork; // "Visa", "Mastercard", "Amex"

    public CreditCardPayment(String paymentId, Reservation reservation,
                             String cardLastFour, String cardHolderName, String cardNetwork) {
        super(paymentId, reservation);
        this.cardLastFour = cardLastFour;
        this.cardHolderName = cardHolderName;
        this.cardNetwork = cardNetwork;
    }

    @Override
    public boolean processPayment(double payAmount) {
        if (payAmount <= 0 || payAmount > getOutstandingBalance()) {
            System.out.println("  Invalid payment amount.");
            return false;
        }
        amountPaid += payAmount;
        status = (amountPaid >= amount) ? "Paid" : "Partial";
        System.out.println("  " + cardNetwork + " card *" + cardLastFour
                + " charged $" + String.format("%.2f", payAmount) + " → " + status);
        return true;
    }

    @Override
    public String getPaymentMethod() { return "Credit Card (" + cardNetwork + ")"; }
}
