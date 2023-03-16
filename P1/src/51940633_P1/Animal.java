public class Animal {

    private String name;
    private double energy;
    private boolean alive;
    private double mealAmount;
    double x, y;
    double speedX, speedY;

    public Animal() {
        energy = 100;
        speedX = 1;
        speedY = 1;
    }

    public double eat() {
        double eatAmt = (100 - energy);
        if (isAlive()) {
            if (eatAmt >= mealAmount) {
                energy += mealAmount;
                System.out.printf("%s ate %.1f units!\n", name, mealAmount);
                return mealAmount;
            } else {
                energy += eatAmt;
                System.out.printf("%s ate %.1f units!\n", name, eatAmt);
                return eatAmt;
            }
        } else {
            System.out.println(name + " is dead!");
            return 0;
        }
    }

    public void sound() {
        if (isAlive()) {
            System.out.println("Unknown sound");
        }
    }

    public void move() {
        if (isAlive()) {
            x += speedX;
            y += speedY;
            energy -= 0.1;
        } else {
            System.out.println(name + " can't move. It is dead!");
        }
    }

    public void speak(String msg) {
        System.out.println(name + " says: " + msg);
    }

    public String toString() {
        if (isAlive()) {
            return name + ": alive  at " + "(" + x + ", " + y + ")" + "Energy: " + energy;
        } else {
            return name + ": dead at " + "(" + x + ", " + y + ")" + "Energy: " + energy;
        }

    }

    public boolean isAlive() {
        if (this.energy > 0) {
            alive = true;
        } else {
            alive = false;
        }
        return alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        if (energy > 0 && energy <= 100) {
            this.energy = energy;
            if (energy <= 17) {
                System.out.println(this.name + " is starving");
            } else if (energy > 17 && energy < 50) {
                System.out.println(this.name + " is hungry");
            }
        } else {
            System.out.println("Invalid value");
        }
    }

    public double getMealAmount() {
        return mealAmount;
    }

    public void setMealAmount(double mealAmount) {
        if (mealAmount > 0 && mealAmount <= 100) {
            this.mealAmount = mealAmount;
        } else {
            System.out.println("Invalid value");
        }

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

}
