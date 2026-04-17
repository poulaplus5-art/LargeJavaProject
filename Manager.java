import java.util.ArrayList;
import java.util.List;

// Concrete Class 11: manager (extends Staff, manages other staff)
public class Manager extends Staff {
    protected String managerTitle;
    protected List<Staff> teamMembers;

    public Manager(String id, String name, String email, String phone,
                   String department, String managerTitle) {
        super(id, name, email, phone, department, 6500.00, "Morning");
        this.managerTitle = managerTitle;
        this.teamMembers = new ArrayList<>();
    }

    public void addTeamMember(Staff staff) {
        teamMembers.add(staff);
        System.out.println("  " + staff.name + " added to " + name + "'s team.");
    }

    public void conductBriefing() {
        System.out.println("  " + name + " conducting briefing for " + teamMembers.size() + " staff:");
        for (Staff s : teamMembers) {
            System.out.println("    • " + s);
        }
    }

    public void approveDiscount(Reservation res, double discountPercent) {
        double saving = res.totalCost * discountPercent;
        res.totalCost -= saving;
        System.out.println("  " + name + " approved " + (discountPercent * 100)
                + "% discount on " + res.reservationId
                + " — saved $" + String.format("%.2f", saving));
    }

    @Override
    public void performDuty() {
        System.out.println("  " + name + " (" + managerTitle + ") is overseeing " + department + " operations.");
    }

    @Override
    public String getRole() { return "Manager"; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Title  : " + managerTitle);
        System.out.println("  Team   : " + teamMembers.size() + " members");
    }
}
