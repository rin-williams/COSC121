public class FruitTest {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[5];
        fruits[0] = new Fruit();
        fruits[1] = new Apple();
        fruits[2] = new Orange();
        fruits[3] = new GoldenDelicious();
        fruits[4] = new McIntosh();
        for (Fruit f1 : fruits) {
            f1.saySomething();
        }
        Fruit[] apples = new Apple[3];
        apples[0] = new Apple();
        apples[1] = new GoldenDelicious();
        apples[2] = new McIntosh();
        for (Fruit f2 : apples) {
            ((Apple) f2).saySomething("Hello World!");
        }
    }
}

class Fruit {
    void saySomething() {
        System.out.println("I am a (Fruit)");
    }
}

class Apple extends Fruit {
    void saySomething() {
        System.out.println("I am an (Apple)");

    }

    void saySomething(String s) {
        System.out.println(s + " said by (Apple)");
    }

    void makeAppleCider() {
        System.out.println("apple cider made");
    }
}

class Orange extends Fruit {
    void saySomething() {
        System.out.println("I am an (Orange)");
    }

    void makeOrangeJuice() {
        System.out.println("orange juice made");
    }
}

class GoldenDelicious extends Apple {
    void saySomething() {
        System.out.println("I am a (Golden Delicious)");
    }
}

class McIntosh extends Apple {
    void saySomething(String s) {
        System.out.println(s + " said by (McIntosh)");
    }

}
