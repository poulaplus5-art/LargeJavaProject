// Concrete Class 19 (Main): demo runner for the Hotel Reservation System
public class Main {

    static void section(String title) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.printf( "║  %-44s║%n", title);
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public static void main(String[] args) {

        // ── 1. Build the Hotel ─────────────────────────────────────
        section("1. HOTEL SETUP");
        Hotel hotel = new Hotel("Azure Grand Hotel", "Dubai, UAE", 5);

        // Rooms
        hotel.addRoom(new StandardRoom("101", 1, true));
        hotel.addRoom(new StandardRoom("102", 1, false));
        hotel.addRoom(new DeluxeRoom("201", 2, "King", true));
        hotel.addRoom(new DeluxeRoom("202", 2, "Queen", false));
        hotel.addRoom(new SuiteRoom("301", 3, 3, true, "Sea"));
        hotel.addRoom(new SuiteRoom("302", 3, 2, false, "City"));

        // Spa & Restaurant
        Spa spa = new Spa("Azure Wellness Spa", 10, 120.00);
        spa.addTreatment("Hot Stone Massage");
        spa.addTreatment("Aromatherapy");
        spa.addTreatment("Deep Tissue Massage");
        hotel.setSpa(spa);

        Restaurant restaurant = new Restaurant("Azure Brasserie", "Mediterranean", 30, 65.00);
        restaurant.addMenuItem("Grilled Sea Bass");
        restaurant.addMenuItem("Lamb Tagine");
        restaurant.addMenuItem("Truffle Risotto");
        hotel.addRestaurant(restaurant);

        hotel.printDetails();

        // ── 2. Staff ────────────────────────────────────────────────
        section("2. STAFF");
        Manager gm = new Manager("MGR-01", "Sarah Al-Hassan", "sarah@azure.com", "+971501111", "Operations", "General Manager");
        Receptionist rec1 = new Receptionist("REC-01", "James Carter", "james@azure.com", "+971502222", "Morning");
        Receptionist rec2 = new Receptionist("REC-02", "Lina Farouk",  "lina@azure.com",  "+971503333", "Evening");
        HouseKeeper hk1  = new HouseKeeper("HK-01",  "Maria Santos",  "maria@azure.com",  "+971504444", "Morning");
        HouseKeeper hk2  = new HouseKeeper("HK-02",  "Tom Nguyen",    "tom@azure.com",    "+971505555", "Evening");

        hotel.addStaff(gm); hotel.addStaff(rec1); hotel.addStaff(rec2);
        hotel.addStaff(hk1); hotel.addStaff(hk2);

        gm.addTeamMember(rec1); gm.addTeamMember(rec2);
        gm.addTeamMember(hk1);  gm.addTeamMember(hk2);

        System.out.println();
        gm.performDuty();
        rec1.performDuty();
        hk1.assignRoom("101"); hk1.assignRoom("102");
        hk2.assignRoom("201"); hk2.assignRoom("202");

        System.out.println();
        System.out.println("  ── Manager Details ──");
        gm.printDetails();

        // ── 3. Guests ───────────────────────────────────────────────
        section("3. GUESTS");
        Guest g1 = new Guest("G001", "Emily Clarke",  "emily@mail.com",  "+44123", "British");
        Guest g2 = new Guest("G002", "Karim Mansour", "karim@mail.com",  "+20456", "Egyptian");
        VIPGuest vip = new VIPGuest("V001", "Sofia Reyes", "sofia@mail.com", "+34789", "Spanish", "Antoine");

        System.out.println(g1); System.out.println(g2); System.out.println(vip);
        System.out.println();
        vip.requestButlerService("Airport pickup in Rolls-Royce");

        // ── 4. Reservations ─────────────────────────────────────────
        section("4. RESERVATIONS");
        Reservation res1 = rec1.createReservation("RES-001", g1,  hotel.findAvailableRoom("Standard"),
                                                   "2025-06-01", "2025-06-05", 4);
        Reservation res2 = rec1.createReservation("RES-002", g2,  hotel.findAvailableRoom("Deluxe"),
                                                   "2025-06-02", "2025-06-07", 5);
        Reservation res3 = rec2.createReservation("RES-003", vip, hotel.findAvailableRoom("Suite"),
                                                   "2025-06-03", "2025-06-10", 7);

        hotel.addReservation(res1);
        hotel.addReservation(res2);
        hotel.addReservation(res3);

        System.out.println();
        System.out.println("  ── Reservation Details ──");
        res1.printDetails();

        // ── 5. Check-in ─────────────────────────────────────────────
        section("5. CHECK-IN");
        res1.checkIn();
        res2.checkIn();
        res3.checkIn();

        // ── 6. Payments ─────────────────────────────────────────────
        section("6. PAYMENTS");
        CreditCardPayment pay1 = new CreditCardPayment("PAY-001", res1, "4242", "Emily Clarke", "Visa");
        CashPayment       pay2 = new CashPayment("PAY-002", res2, rec1.name);
        CreditCardPayment pay3 = new CreditCardPayment("PAY-003", res3, "9999", "Sofia Reyes", "Amex");

        pay1.processPayment(res1.totalCost);
        pay2.processPayment(res2.totalCost + 50); // extra cash → change given
        pay3.processPayment(res3.totalCost * 0.5); // partial first
        pay3.processPayment(res3.totalCost * 0.5); // settle remaining

        System.out.println();
        pay1.printReceipt();

        // ── 7. Manager Discount ──────────────────────────────────────
        section("7. MANAGER DISCOUNT");
        Reservation res4 = rec2.createReservation("RES-004", g2,
                hotel.findAvailableRoom("Standard"),
                "2025-07-01", "2025-07-03", 2);
        hotel.addReservation(res4);
        System.out.println("  Before discount: $" + String.format("%.2f", res4.totalCost));
        gm.approveDiscount(res4, 0.20);
        System.out.println("  After discount : $" + String.format("%.2f", res4.totalCost));

        // ── 8. Spa & Restaurant ──────────────────────────────────────
        section("8. SPA & RESTAURANT");
        spa.book(vip.name, "2025-06-04", "2025-06-04");
        spa.book(g1.name,  "2025-06-04", "2025-06-04");
        System.out.println("  Spa cost for 2 sessions: $" + spa.calculateCost(2));
        System.out.println();
        restaurant.reserveTable(g2.name);
        restaurant.reserveTable(vip.name);
        restaurant.printDetails();

        // ── 9. Housekeeping ──────────────────────────────────────────
        section("9. HOUSEKEEPING");
        hk1.cleanRoom("101");
        hk1.cleanRoom("102");
        hk2.cleanRoom("201");

        // ── 10. Check-out ────────────────────────────────────────────
        section("10. CHECK-OUT");
        res1.checkOut();
        res2.checkOut();

        // ── 11. Feedback ─────────────────────────────────────────────
        section("11. GUEST FEEDBACK");
        FeedbackReport fb1 = new FeedbackReport("FB-001", g1,  res1, 5,
                "Absolutely stunning stay!", "Overall", "2025-06-05");
        FeedbackReport fb2 = new FeedbackReport("FB-002", g2,  res2, 4,
                "Deluxe room was very comfortable.", "Room", "2025-06-07");
        FeedbackReport fb3 = new FeedbackReport("FB-003", vip, res3, 5,
                "Butler Antoine was exceptional.", "Service", "2025-06-10");

        hotel.addFeedback(fb1);
        hotel.addFeedback(fb2);
        hotel.addFeedback(fb3);

        fb1.printDetails();

        // ── 12. Polymorphism showcase ────────────────────────────────
        section("12. POLYMORPHISM — ALL ROOMS");
        System.out.println("  Rooms & costs for 3 nights (via Room[] polymorphism):");
        Room[] allRooms = { new StandardRoom("X01",1,false),
                            new DeluxeRoom("X02",2,"King",false),
                            new SuiteRoom("X03",3,2,false,"Garden") };
        for (Room r : allRooms) {
            System.out.printf("    %-10s → 3-night cost: $%.2f | Max guests: %d%n",
                    r.getRoomType(), r.calculateCost(3), r.getMaxGuests());
        }

        section("13. POLYMORPHISM — ALL STAFF");
        Staff[] allStaff = { gm, rec1, hk1 };
        for (Staff s : allStaff) {
            s.performDuty();
        }

        // ── 14. Hotel Reports ────────────────────────────────────────
        section("14. HOTEL REPORTS");
        System.out.println("  ── Occupancy ──");
        hotel.printOccupancyReport();
        System.out.println("\n  ── Revenue ──");
        hotel.printRevenueReport();
        System.out.println("\n  ── Feedback Summary ──");
        hotel.printFeedbackSummary();

        System.out.println("\n✔ Hotel Reservation System demo complete.\n");
    }
}
