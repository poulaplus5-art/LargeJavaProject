// Concrete Class 2: VIP guest with extra perks (extends Guest → polymorphism)
public class VIPGuest extends Guest {
    protected String personalButler;
    protected boolean airportTransfer;
    protected String preferredRoom;

    public VIPGuest(String id, String name, String email, String phone,
                    String nationality, String personalButler) {
        super(id, name, email, phone, nationality);
        this.personalButler = personalButler;
        this.airportTransfer = true;
        this.loyaltyTier = "Gold";
        this.loyaltyPoints = 1000;
    }

    public void requestButlerService(String service) {
        System.out.println("  Butler '" + personalButler + "' handling: " + service + " for " + name);
    }

    @Override
    public double getLoyaltyDiscount() {
        return 0.25; // VIPs always get 25%
    }

    @Override
    public String getRole() { return "VIP Guest"; }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Butler : " + personalButler);
        System.out.println("  Transfer: " + (airportTransfer ? "Included" : "Not included"));
    }

    @Override
    public String toString() {
        return "[VIP] " + name + " | Butler: " + personalButler;
    }
}
