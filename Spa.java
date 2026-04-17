import java.util.ArrayList;
import java.util.List;

// Concrete Class 16: hotel spa (implements Bookable + Describable)
public class Spa implements Bookable, Describable {
    protected String name;
    protected List<String> treatments;
    protected int totalSlots;
    protected int bookedSlots;
    protected double pricePerSession;

    public Spa(String name, int totalSlots, double pricePerSession) {
        this.name = name;
        this.totalSlots = totalSlots;
        this.bookedSlots = 0;
        this.pricePerSession = pricePerSession;
        this.treatments = new ArrayList<>();
    }

    public void addTreatment(String treatment) {
        treatments.add(treatment);
    }

    @Override
    public boolean book(String guestName, String checkIn, String checkOut) {
        if (bookedSlots >= totalSlots) {
            System.out.println("  " + name + " is fully booked.");
            return false;
        }
        bookedSlots++;
        System.out.println("  Spa session booked for " + guestName
                + " on " + checkIn + " (" + bookedSlots + "/" + totalSlots + " slots)");
        return true;
    }

    @Override
    public boolean cancelBooking(String reservationId) {
        if (bookedSlots > 0) bookedSlots--;
        System.out.println("  Spa booking " + reservationId + " cancelled.");
        return true;
    }

    @Override
    public boolean isAvailable(String checkIn, String checkOut) {
        return bookedSlots < totalSlots;
    }

    @Override
    public double calculateCost(int sessions) {
        return pricePerSession * sessions;
    }

    @Override
    public String getDescription() {
        return name + " | " + treatments.size() + " treatments | $"
                + String.format("%.2f", pricePerSession) + "/session | "
                + (totalSlots - bookedSlots) + " slots free";
    }

    @Override
    public void printDetails() {
        System.out.println("  Spa        : " + name);
        System.out.println("  Treatments : " + treatments);
        System.out.println("  Price      : $" + String.format("%.2f", pricePerSession) + "/session");
        System.out.println("  Slots      : " + bookedSlots + "/" + totalSlots + " booked");
    }

    @Override
    public String toString() {
        return "[Spa] " + name + " - " + (totalSlots - bookedSlots) + " slots available";
    }
}
