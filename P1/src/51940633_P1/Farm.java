public class Farm {
    Animal[] animals = new Animal[4];
    private double availableFood;

    public Farm() {
        animals[0] = new Chicken();
        animals[1] = new Cow();
        animals[2] = new Llama();
        animals[3] = new Llama();
        setAvailableFood(1000);
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAvailableFood(double availableFood) {
        this.availableFood = availableFood;
    }

    public double getAvailableFood() {
        return availableFood;
    }

    public void makeNoise() {
        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();
        }
    }

    public void feedAnimals() {
        for (int i = 0; i < animals.length; i++) {
            if ((availableFood - animals[i].getMealAmount()) > 0) {
                availableFood -= animals[i].eat();

            } else {
                System.out.println("Not enough food to feed the animals.");
            }

        }
    }

}
