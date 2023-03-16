import java.util.Scanner;

public class TestHexagon {
    public static void main(String[] args) throws CloneNotSupportedException {
        Hexagon hexa = new Hexagon();

        Scanner in = new Scanner(System.in);

        System.out.print("Color: ");
        hexa.setColor(in.nextLine());

        System.out.print("Filled? (yes/no): ");
        hexa.setFilled(in.nextLine().contains("y") ? true : false);

        System.out.print("Side length: ");
        hexa.setLength(in.nextDouble());

        System.out.println("\nFirst Hexagon" + "\n" + hexa.toString());

        Hexagon clonned = (Hexagon) hexa.clone();

        System.out.println("\nCloned Hexagon" + "\n" + clonned.toString());

        if (hexa.compareTo(clonned) == 0) {
            System.out.println("Both hexagons are identical.");
        } else if (hexa.compareTo(clonned) == -1) {
            System.out.println("Your hexagon is smaller than the clonned.");
        } else {
            System.out.println("Your hexagon is bigger than the clonned.");
        }

        in.close();
    }
}
