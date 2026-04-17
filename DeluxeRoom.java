// Concrete Class 4: deluxe room
public class DeluxeRoom extends Room {
    protected String bedType;   // "King", "Queen"
    protected boolean hasJacuzzi;

    public DeluxeRoom(String roomNumber, int floor, String bedType, boolean hasJacuzzi) {
        super(roomNumber, floor, 150.00);
        this.bedType = bedType;
        this.hasJacuzzi = hasJacuzzi;
        addAmenity("WiFi");
        addAmenity("Smart TV");
        addAmenity("Mini Bar");
        addAmenity(bedType + " Bed");
        if (hasJacuzzi) addAmenity("Jacuzzi");
    }

    @Override
    public boolean book(String guestName, String checkIn, String checkOut) {
        if (occupied) {
            System.out.println("  Room " + roomNumber + " is already occupied.");
            return false;
        }
        occupied = true;
        System.out.println("  Deluxe Room " + roomNumber + " booked for " + guestName
                + " [" + checkIn + " → " + checkOut + "]");
        return true;
    }

    @Override
    public boolean cancelBooking(String reservationId) {
        occupied = false;
        System.out.println("  Deluxe Room " + roomNumber + " booking cancelled.");
        return true;
    }

    @Override
    public double calculateCost(int nights) {
        double base = pricePerNight * nights;
        return hasJacuzzi ? base + (20.0 * nights) : base; // jacuzzi surcharge
    }

    @Override
    public String getRoomType() { return "Deluxe"; }

    @Override
    public int getMaxGuests() { return 2; }
}
