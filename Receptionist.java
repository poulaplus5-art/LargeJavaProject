import java.util.ArrayList;
import java.util.List;

// Concrete Class 9: receptionist
public class Receptionist extends Staff {
    protected int reservationsHandled;
    protected List<String> managedReservations;

    public Receptionist(String id, String name, String email, String phone, String shift) {
        super(id, name, email, phone, "Front Desk", 2800.00, shift);
        this.reservationsHandled = 0;
        this.managedReservations = new ArrayList<>();
    }

    public Reservation createReservation(String resId, Guest guest, Room room,
                                          String checkIn, String checkOut, int nights) {
        if (!room.isAvailable(checkIn, checkOut)) {
            System.out.println("  Room not available.");
            return null;
        }
        room.book(guest.name, checkIn, checkOut);
        Reservation res = new Reservation(resId, guest, room, checkIn, checkOut, nights);
        guest.addReservation(resId);
        managedReservations.add(resId);
        reservationsHandled++;
        System.out.println("  Receptionist " + name + " created reservation " + resId);
        return res;
    }

    @Override
    public void performDuty() {
        System.out.println("  " + name + " is managing check-ins and check-outs at the front desk.");
    }

    @Override
    public String getRole() { return "Receptionist"; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Reservations Handled: " + reservationsHandled);
    }
}
