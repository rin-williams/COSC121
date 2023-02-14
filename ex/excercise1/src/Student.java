public class Student extends Person {
    private String status;

    public Student() {
        status = "null";
    }

    public Student(String name, String address, String phone, String email, String status) {
        super(name, address, phone, email);
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "\nstatus: " + status;
    }
}
