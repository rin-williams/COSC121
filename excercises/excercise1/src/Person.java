
public class Person {
    private String name, address, phone, email;

    public Person() {
        name = "null";
        address = "null";
        phone = "null";
        email = "null";
    }

    public Person(String name, String address, String phone, String email) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name: " + name + "\naddy: " + address + "\ncellular number: " + phone + "\nemail: " + email;
    }

}
