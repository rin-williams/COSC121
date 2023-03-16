public class Llama extends Animal {

    private static int id = 1;

    public Llama() {
        setMealAmount(9);
        setName("Llama " + id);
        id++;
    }

    public void sound() {
        if (isAlive()) {
            System.out.println("Hmmm!");
        }
    }

    public void jump() {
        System.out.println("I use my legs as springs and go boing");
    }
}
