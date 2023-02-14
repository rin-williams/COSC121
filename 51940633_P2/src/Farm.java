import java.util.Arrays;

public class Farm {
	private double availableFood;
	private Animal[] animals;
	private int nAnim = 0;

	public Farm() {
		setAvailableFood(1000);
		animals = new Animal[100];

		add(new Chicken());
		add(new Cow());
		add(new Llama());
		add(new Llama());
	}

	public boolean add(Animal anim) {
		if (nAnim < 100) {
			animals[nAnim++] = anim;
			return true;
		}
		return false;

	}

	public void makeNoise() { // all animals make their sound (Moo, Cluck, etc)
		for (Animal animal : animals)
			animal.sound();
	}

	public void feedAnimals() { // restore energy of all animals and deduct amount eaten from availableFood
		for (Animal animal : animals)
			if (availableFood >= Math.min(animal.getMealAmount(), (100 - animal.getEnergy())))
				// no penalty if student uses: if(availableFood >= animal.getMealAmount())
				availableFood -= animal.eat();
			else
				System.out.println("Not enough food for your animals! You need to collect more food items.");
	}

	public double getAvailableFood() {
		return availableFood;
	}

	public void setAvailableFood(double availableFood) {
		if (availableFood >= 0 && availableFood <= 1000)
			this.availableFood = availableFood;
	}

	public Animal[] getAnimals() {
		Animal[] availAnimal = new Animal[nAnim];
		System.arraycopy(animals, 0, availAnimal, 0, nAnim);
		return availAnimal;
	}

	public void animSort() {
		Animal[] sortedAnimal = getAnimals();
		Arrays.sort(sortedAnimal);
		System.arraycopy(sortedAnimal, 0, animals, 0, nAnim);
	}

	public boolean addClone(Animal anim) throws CloneNotSupportedException {
		Animal clonedAnim = (Animal) anim.clone();
		return add(clonedAnim);
	}

	public void printAnimals() {

		for (int i = 0; i < nAnim; i++) {
			System.out.printf("%-8s: %-5s at (%-2.1f,%-2.1f) Energy=%-7.1f\n", animals[i].getName(),
					animals[i].isAlive() ? "alive" : "dead",
					animals[i].getX(),
					animals[i].getY(),
					animals[i].getEnergy());
		}
	}

	public int getNumChicken() {
		int count = 0;
		for (int i = 0; i < nAnim; i++) {
			if (animals[i] instanceof Chicken) {
				count++;
			}
		}
		return count;
	}

	public int getNumCows() {
		int count = 0;
		for (int i = 0; i < nAnim; i++) {
			if (animals[i] instanceof Cow) {
				count++;
			}
		}
		return count;
	}

	public int getNumLlamas() {
		int count = 0;
		for (int i = 0; i < nAnim; i++) {
			if (animals[i] instanceof Llama) {
				count++;
			}
		}
		return count;
	}

	public void printSummary() {
		int totalAnim = getNumChicken() + getNumCows() + getNumLlamas();
		System.out.print("The farm has:");

		// for defensive programming reasons

		System.out.print("\n- " + (totalAnim > 1 ? totalAnim + " animals" : totalAnim + " animal ") + " ("
				+ (getNumChicken() > 1 ? getNumChicken() + " Chickens, " : getNumChicken() + " Chicken, ")
				+ (getNumCows() > 1 ? getNumCows() + " Cows, " : getNumCows() + " Cow, ")
				+ (getNumLlamas() > 1 ? getNumLlamas() + " Llamas)" : getNumLlamas() + " Llama)"));
		System.out.print("\n- " + getAvailableFood() + " units of available food");
	}

}
