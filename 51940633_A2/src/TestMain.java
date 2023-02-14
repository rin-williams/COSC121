import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Shape[] shapes1 = new Shape[5];
        shapes1[0] = new Rectangle("White", true, 10, 50);
        shapes1[1] = new Rectangle("Blue", true, 20, 15);
        shapes1[2] = new Rectangle("White", false, 10, 25);
        shapes1[3] = new Hexagon("Black", false, 5);
        shapes1[4] = new Hexagon("White", true, 25);

        double totalArea = 0;
        Shape[] shapes2 = new Shape[shapes1.length];

        for (int i = 0; i < shapes1.length; i++) {
            totalArea += shapes1[i].getArea();
            shapes2[i] = (Shape) shapes1[i].clone();

        }
        System.out.println("Total area of all shapes in 'shapes1' is " + totalArea);

        System.out.println("\nshapes1 has been cloned to shapes2");

        Arrays.sort(shapes2);

        System.out.println("shapes2 has been reordered!");

        System.out.printf("\n%-19s %-15s", "Areas in shapes1", "Areas in shapes2\n");

        for (int i = 0; i < shapes1.length; i++) {
            System.out.printf("%-19.2f %.2f\n", shapes1[i].getArea(), shapes2[i].getArea());
        }

    }
}
