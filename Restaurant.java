import java.util.ArrayList;
import java.util.List;

// Concrete Class 12: hotel restaurant
public class Restaurant implements Describable {
    protected String name;
    protected String cuisine;
    protected int totalTables;
    protected int occupiedTables;
    protected List<String> menu;
    protected double averageMealPrice;

    public Restaurant(String name, String cuisine, int totalTables, double averageMealPrice) {
        this.name = name;
        this.cuisine = cuisine;
        this.totalTables = totalTables;
        this.occupiedTables = 0;
        this.averageMealPrice = averageMealPrice;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(String item) {
        menu.add(item);
    }

    public boolean reserveTable(String guestName) {
        if (occupiedTables >= totalTables) {
            System.out.println("  " + name + " is fully booked.");
            return false;
        }
        occupiedTables++;
        System.out.println("  Table reserved at " + name + " for " + guestName
                + " (" + occupiedTables + "/" + totalTables + " tables)");
        return true;
    }

    public void releaseTable() {
        if (occupiedTables > 0) occupiedTables--;
    }

    @Override
    public String getDescription() {
        return name + " | " + cuisine + " | " + (totalTables - occupiedTables) + " tables free";
    }

    @Override
    public void printDetails() {
        System.out.println("  Restaurant : " + name);
        System.out.println("  Cuisine    : " + cuisine);
        System.out.println("  Tables     : " + occupiedTables + "/" + totalTables + " occupied");
        System.out.println("  Avg Price  : $" + String.format("%.2f", averageMealPrice));
        System.out.println("  Menu items : " + menu.size());
    }

    @Override
    public String toString() {
        return "[Restaurant] " + name + " (" + cuisine + ")";
    }
    
    public void NewMethod7() {
}
}
