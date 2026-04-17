// Abstract Class 3: base for all hotel staff
public abstract class Staff extends Person {
    protected String department;
    protected double salary;
    protected String shift; // "Morning", "Evening", "Night"

    public Staff(String id, String name, String email, String phone,
                 String department, double salary, String shift) {
        super(id, name, email, phone);
        this.department = department;
        this.salary = salary;
        this.shift = shift;
    }

    public abstract void performDuty();

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("  Dept   : " + department);
        System.out.println("  Salary : $" + String.format("%.2f", salary));
        System.out.println("  Shift  : " + shift);
    }

    @Override
    public String toString() {
        return "[Staff] " + name + " - " + department + " (" + shift + " shift)";
    }
}
