import java.util.ArrayList;
import java.util.List;

// Concrete Class 1: hotel guest
public class Guest extends Person {
    protected String nationality;
    protected String loyaltyTier; // "Bronze", "Silver", "Gold"
    protected int loyaltyPoints;
    protected List<String> reservationHistory;

    public Guest(String id, String name, String email, String phone,
                 String nationality) {
        super(id, name, email, phone);
        this.nationality = nationality;
        this.loyaltyTier = "Bronze";
        this.loyaltyPoints = 0;
        this.reservationHistory = new ArrayList<>();
    }

    public void addReservation(String reservationId) {
        reservationHistory.add(reservationId);
        loyaltyPoints += 100;
        updateTier();
    }

    protected void updateTier() {
        if (loyaltyPoints >= 500) loyaltyTier = "Gold";
        else if (loyaltyPoints >= 200) loyaltyTier = "Silver";
        else loyaltyTier = "Bronze";
    }

    public double getLoyaltyDiscount() {
        switch (loyaltyTier) {
            case "Gold":   return 0.15;
            case "Silver": return 0.10;
            default:       return 0.0;
        }
    }

    @Override
    public String getRole() { return "Guest"; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Country: " + nationality);
        System.out.println("  Tier   : " + loyaltyTier + " (" + loyaltyPoints + " pts)");
        System.out.println("  Stays  : " + reservationHistory.size());
    }

    @Override
    public String toString() {
        return "[Guest] " + name + " - " + loyaltyTier + " member";
    }
}
