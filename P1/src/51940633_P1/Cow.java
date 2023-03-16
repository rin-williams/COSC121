public class Cow extends Animal {

    private static int id = 1;

    public Cow() {
        setMealAmount(20);
        setName("Cow " + id);
        id++;

    }

    public void sound() {
        if (isAlive()) {
            System.out.println("Moo!");
        }
    }

    public void milk() {
        System.out.println("what are you doing fam");
    }
}
