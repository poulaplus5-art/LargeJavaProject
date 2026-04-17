// Concrete Class 6: a reservation record
public class Reservation implements Describable {
    protected String reservationId;
    protected Guest guest;
    protected Room room;
    protected String checkIn;
    protected String checkOut;
    protected int nights;
    protected double totalCost;
    protected String status; // "Confirmed", "Cancelled", "CheckedIn", "CheckedOut"

    public Reservation(String reservationId, Guest guest, Room room,
                       String checkIn, String checkOut, int nights) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
        double baseCost = room.calculateCost(nights);
        double discount = guest.getLoyaltyDiscount();
        this.totalCost = baseCost * (1 - discount);
        this.status = "Confirmed";
    }

    public void checkIn() {
        status = "CheckedIn";
        System.out.println("  ✔ Check-in: " + guest.name + " → Room " + room.roomNumber);
    }

    public void checkOut() {
        status = "CheckedOut";
        room.occupied = false;
        System.out.println("  ✔ Check-out: " + guest.name + " from Room " + room.roomNumber);
    }

    public void cancel() {
        status = "Cancelled";
        room.cancelBooking(reservationId);
        System.out.println("  ✘ Reservation " + reservationId + " cancelled.");
    }

    @Override
    public String getDescription() {
        return "Reservation " + reservationId + " | " + guest.name
                + " | Room " + room.roomNumber + " | " + checkIn + " → " + checkOut;
    }

    @Override
    public void printDetails() {
        System.out.println("  Reservation ID : " + reservationId);
        System.out.println("  Guest          : " + guest.name + " [" + guest.loyaltyTier + "]");
        System.out.println("  Room           : " + room.getDescription());
        System.out.println("  Check-in       : " + checkIn);
        System.out.println("  Check-out      : " + checkOut);
        System.out.println("  Nights         : " + nights);
        System.out.println("  Total Cost     : $" + String.format("%.2f", totalCost));
        System.out.println("  Status         : " + status);
    }

    @Override
    public String toString() {
        return "[" + reservationId + "] " + guest.name + " | Room " + room.roomNumber
                + " | $" + String.format("%.2f", totalCost) + " | " + status;
    }
}
