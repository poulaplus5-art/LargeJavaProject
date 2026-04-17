import java.util.ArrayList;
import java.util.List;

// Abstract Class 2: base for all room types
public abstract class Room implements Bookable, Describable {
    protected String roomNumber;
    protected int floor;
    protected double pricePerNight;
    protected boolean occupied;
    protected List<String> amenities;

    public Room(String roomNumber, int floor, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.pricePerNight = pricePerNight;
        this.occupied = false;
        this.amenities = new ArrayList<>();
    }

    public abstract String getRoomType();
    public abstract int getMaxGuests();

    protected void addAmenity(String amenity) {
        amenities.add(amenity);
    }

    @Override
    public boolean isAvailable(String checkIn, String checkOut) {
        return !occupied;
    }

    @Override
    public double calculateCost(int nights) {
        return pricePerNight * nights;
    }

    @Override
    public void printDetails() {
        System.out.println("  Room    : " + roomNumber + " (Floor " + floor + ")");
        System.out.println("  Type    : " + getRoomType());
        System.out.println("  Price   : $" + String.format("%.2f", pricePerNight) + "/night");
        System.out.println("  Guests  : up to " + getMaxGuests());
        System.out.println("  Status  : " + (occupied ? "Occupied" : "Available"));
        System.out.println("  Amenities: " + amenities);
    }

    @Override
    public String getDescription() {
        return getRoomType() + " Room " + roomNumber + " @ $" + pricePerNight + "/night";
    }

    @Override
    public String toString() {
        return "[" + getRoomType() + "] Room " + roomNumber + " - " + (occupied ? "Occupied" : "Available");
    }
}
