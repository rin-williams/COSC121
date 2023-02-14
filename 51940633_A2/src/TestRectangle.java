import java.util.Scanner;

public class TestRectangle {

    public static void main(String[] args) throws CloneNotSupportedException {
        Rectangle rect = new Rectangle();

        Scanner in = new Scanner(System.in);

        System.out.print("Color: ");
        rect.setColor(in.nextLine());

        System.out.print("Filled? (yes/no): ");
        rect.setFilled(in.nextLine().contains("y") ? true : false);

        System.out.print("Width and height: ");
        rect.setWidth(in.nextDouble());
        rect.setHeight(in.nextDouble());

        System.out.println("\nFirst rectangle" + "\n" + rect.toString());

        Rectangle clonned = (Rectangle) rect.clone();

        System.out.println("\nCloned rectangle" + "\n" + clonned.toString());

        if (rect.compareTo(clonned) == 0) {
            System.out.println("Both rectangles are identical.");
        } else if (rect.compareTo(clonned) == -1) {
            System.out.println("Your rectangle is smaller than the clonned.");
        } else {
            System.out.println("Your rectangle is bigger than the clonned.");
        }

        in.close();

    }

}
