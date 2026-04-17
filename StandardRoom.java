// Concrete Class 3: standard room
public class StandardRoom extends Room {
    protected boolean hasBalcony;

    public StandardRoom(String roomNumber, int floor, boolean hasBalcony) {
        super(roomNumber, floor, 80.00);
        this.hasBalcony = hasBalcony;
        addAmenity("WiFi");
        addAmenity("TV");
        addAmenity("Air Conditioning");
        if (hasBalcony) addAmenity("Balcony");
    }

    @Override
    public boolean book(String guestName, String checkIn, String checkOut) {
        if (occupied) {
            System.out.println("  Room " + roomNumber + " is already occupied.");
            return false;
        }
        occupied = true;
        System.out.println("  Standard Room " + roomNumber + " booked for " + guestName
                + " [" + checkIn + " → " + checkOut + "]");
        return true;
    }

    @Override
    public boolean cancelBooking(String reservationId) {
        occupied = false;
        System.out.println("  Standard Room " + roomNumber + " booking cancelled.");
        return true;
    }

    @Override
    public String getRoomType() { return "Standard"; }

    @Override
    public int getMaxGuests() { return 2; }
}
