// Concrete Class 17: guest feedback and review
public class FeedbackReport implements Describable {
    protected String feedbackId;
    protected Guest guest;
    protected Reservation reservation;
    protected int rating;        // 1–5
    protected String comment;
    protected String category;   // "Room", "Service", "Food", "Overall"
    protected String submittedOn;

    public FeedbackReport(String feedbackId, Guest guest, Reservation reservation,
                          int rating, String comment, String category, String submittedOn) {
        this.feedbackId = feedbackId;
        this.guest = guest;
        this.reservation = reservation;
        this.rating = Math.min(5, Math.max(1, rating)); // clamp to 1-5
        this.comment = comment;
        this.category = category;
        this.submittedOn = submittedOn;
    }

    public String getStarRating() {
        return "★".repeat(rating) + "☆".repeat(5 - rating);
    }

    public boolean isPositive() {
        return rating >= 4;
    }

    @Override
    public String getDescription() {
        return feedbackId + " | " + guest.name + " | " + category
                + " | " + getStarRating() + " | \"" + comment + "\"";
    }

    @Override
    public void printDetails() {
        System.out.println("  Feedback ID  : " + feedbackId);
        System.out.println("  Guest        : " + guest.name);
        System.out.println("  Reservation  : " + reservation.reservationId);
        System.out.println("  Category     : " + category);
        System.out.println("  Rating       : " + getStarRating() + " (" + rating + "/5)");
        System.out.println("  Comment      : \"" + comment + "\"");
        System.out.println("  Date         : " + submittedOn);
        System.out.println("  Sentiment    : " + (isPositive() ? "Positive ✔" : "Needs Improvement ✘"));
    }

    @Override
    public String toString() {
        return "[Feedback] " + guest.name + " | " + category + " | " + getStarRating();
    }
}
