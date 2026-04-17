// Interface 1: anything that can be reserved
public interface Bookable {
    boolean book(String guestName, String checkIn, String checkOut);
    boolean cancelBooking(String reservationId);
    boolean isAvailable(String checkIn, String checkOut);
    double calculateCost(int nights);
}
