
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        // setting up random numbers
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        Scanner in = new Scanner(System.in);

        // exception handling

        System.out.print("\n(exception handling) Enter an index: ");

        while (true) {
            try {
                System.out.println("The element is " + arr[in.nextInt()]);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Out of bounds. Try again: ");
            }
        }
        // ----

        // defensive programming

        int j;

        System.out.print("\n(defensive programming) Enter an index: ");

        while (((j = in.nextInt()) > 49 || j < 0)) {
            System.out.print("Out of bounds. Try again: ");
        }
        System.out.println("The element is " + arr[j]);

        in.close();

    }
}
