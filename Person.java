// Abstract Class 1: base for all people in the system
public abstract class Person implements Describable {
    protected String id;
    protected String name;
    protected String email;
    protected String phone;

    public Person(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public abstract String getRole();

    @Override
    public void printDetails() {
        System.out.println("  ID    : " + id);
        System.out.println("  Name  : " + name);
        System.out.println("  Role  : " + getRole());
        System.out.println("  Email : " + email);
        System.out.println("  Phone : " + phone);
    }

    @Override
    public String getDescription() {
        return getRole() + " | " + name + " (" + email + ")";
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name;
    }
}
