import java.util.ArrayList;
import java.util.List;

// Concrete Class 10: housekeeper
public class HouseKeeper extends Staff {
    protected List<String> assignedRooms;
    protected int roomsCleanedToday;

    public HouseKeeper(String id, String name, String email, String phone, String shift) {
        super(id, name, email, phone, "Housekeeping", 1800.00, shift);
        this.assignedRooms = new ArrayList<>();
        this.roomsCleanedToday = 0;
    }

    public void assignRoom(String roomNumber) {
        assignedRooms.add(roomNumber);
        System.out.println("  Room " + roomNumber + " assigned to " + name);
    }

    public void cleanRoom(String roomNumber) {
        if (assignedRooms.contains(roomNumber)) {
            roomsCleanedToday++;
            System.out.println("  " + name + " cleaned Room " + roomNumber
                    + " (" + roomsCleanedToday + " rooms today)");
        } else {
            System.out.println("  Room " + roomNumber + " not assigned to " + name);
        }
    }

    @Override
    public void performDuty() {
        System.out.println("  " + name + " is cleaning and restocking assigned rooms: " + assignedRooms);
    }

    @Override
    public String getRole() { return "HouseKeeper"; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Assigned Rooms : " + assignedRooms);
        System.out.println("  Cleaned Today  : " + roomsCleanedToday);
    }
}
