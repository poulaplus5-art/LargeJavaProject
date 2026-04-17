import java.util.ArrayList;
import java.util.List;

// Concrete Class 18: main hotel — holds all rooms, staff, reservations
public class Hotel implements Describable {
    protected String hotelName;
    protected String location;
    protected int starRating;
    protected List<Room> rooms;
    protected List<Staff> staffList;
    protected List<Reservation> reservations;
    protected List<Restaurant> restaurants;
    protected List<FeedbackReport> feedbacks;
    protected Spa spa;

    public Hotel(String hotelName, String location, int starRating) {
        this.hotelName = hotelName;
        this.location = location;
        this.starRating = starRating;
        this.rooms = new ArrayList<>();
        this.staffList = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    // ── Setup ──────────────────────────────────────────
    public void addRoom(Room room)             { rooms.add(room); }
    public void addStaff(Staff staff)          { staffList.add(staff); }
    public void addReservation(Reservation r)  { reservations.add(r); }
    public void addRestaurant(Restaurant r)    { restaurants.add(r); }
    public void addFeedback(FeedbackReport f)  { feedbacks.add(f); }
    public void setSpa(Spa spa)                { this.spa = spa; }

    // ── Queries ────────────────────────────────────────
    public Room findAvailableRoom(String type) {
        for (Room r : rooms) {
            if (r.getRoomType().equalsIgnoreCase(type) && !r.occupied)
                return r;
        }
        return null;
    }

    public Reservation findReservation(String resId) {
        for (Reservation r : reservations) {
            if (r.reservationId.equals(resId)) return r;
        }
        return null;
    }

    // ── Reports ────────────────────────────────────────
    public void printOccupancyReport() {
        long occupied = rooms.stream().filter(r -> r.occupied).count();
        System.out.println("  Occupancy: " + occupied + "/" + rooms.size()
                + " rooms (" + String.format("%.0f", (occupied * 100.0 / rooms.size())) + "%)");
        for (Room r : rooms) {
            System.out.println("    " + r);
        }
    }

    public void printRevenueReport() {
        double total = reservations.stream().mapToDouble(r -> r.totalCost).sum();
        System.out.println("  Total Revenue from " + reservations.size()
                + " reservations: $" + String.format("%.2f", total));
    }

    public void printFeedbackSummary() {
        if (feedbacks.isEmpty()) { System.out.println("  No feedback yet."); return; }
        double avg = feedbacks.stream().mapToInt(f -> f.rating).average().orElse(0);
        long positive = feedbacks.stream().filter(FeedbackReport::isPositive).count();
        System.out.println("  Feedback: " + feedbacks.size() + " reviews | Avg: "
                + String.format("%.1f", avg) + "/5 | Positive: " + positive);
        for (FeedbackReport f : feedbacks) System.out.println("    " + f);
    }

    @Override
    public String getDescription() {
        return hotelName + " | " + location + " | " + starRating + "-Star | "
                + rooms.size() + " rooms | " + staffList.size() + " staff";
    }

    @Override
    public void printDetails() {
        System.out.println("  Hotel      : " + hotelName);
        System.out.println("  Location   : " + location);
        System.out.println("  Stars      : " + "★".repeat(starRating));
        System.out.println("  Rooms      : " + rooms.size());
        System.out.println("  Staff      : " + staffList.size());
        System.out.println("  Restaurant : " + restaurants.size());
        System.out.println("  Spa        : " + (spa != null ? spa.name : "None"));
    }

    @Override
    public String toString() {
        return hotelName + " (" + starRating + "★) — " + location;
    }
}
