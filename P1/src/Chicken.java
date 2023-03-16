public class Chicken extends Animal {

    private static int id = 1;

    public Chicken() {
        setMealAmount(5);
        setName("Chicken " + id);
        id++;
    }

    public void sound() {
        if (isAlive()) {
            System.out.println("Cluck!");
        }
    }

    public void swim() {
        System.out.println("I don't think I can swim...");
    }

}
