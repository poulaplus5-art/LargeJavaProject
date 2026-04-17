// Concrete Class 5: suite room
public class SuiteRoom extends Room {
    protected int numberOfRooms;
    protected boolean hasPrivatePool;
    protected String viewType; // "Sea", "City", "Garden"

    public SuiteRoom(String roomNumber, int floor, int numberOfRooms,
                     boolean hasPrivatePool, String viewType) {
        super(roomNumber, floor, 450.00);
        this.numberOfRooms = numberOfRooms;
        this.hasPrivatePool = hasPrivatePool;
        this.viewType = viewType;
        addAmenity("WiFi");
        addAmenity("Home Theater");
        addAmenity("Full Kitchen");
        addAmenity("Butler Service");
        addAmenity(viewType + " View");
        if (hasPrivatePool) addAmenity("Private Pool");
    }

    @Override
    public boolean book(String guestName, String checkIn, String checkOut) {
        if (occupied) {
            System.out.println("  Suite " + roomNumber + " is already occupied.");
            return false;
        }
        occupied = true;
        System.out.println("  Suite " + roomNumber + " booked for " + guestName
                + " [" + checkIn + " → " + checkOut + "] — Welcome, valued guest!");
        return true;
    }

    @Override
    public boolean cancelBooking(String reservationId) {
        occupied = false;
        System.out.println("  Suite " + roomNumber + " booking cancelled.");
        return true;
    }

    @Override
    public double calculateCost(int nights) {
        double base = pricePerNight * nights;
        if (hasPrivatePool) base += 100.0 * nights;
        return base;
    }

    @Override
    public String getRoomType() { return "Suite"; }

    @Override
    public int getMaxGuests() { return numberOfRooms * 2; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Rooms   : " + numberOfRooms);
        System.out.println("  View    : " + viewType);
    }
}
