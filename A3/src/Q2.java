
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double res = 0;

        System.out.print("Enter a simple mathematical formula: ");

        loop: while (true) {
            try {
                double n1 = in.nextDouble();
                String op = in.next();
                double n2 = in.nextDouble();
                switch (op) {
                    case "+":
                        res = n1 + n2;
                        System.out.println("result: " + res);
                        break loop;
                    case "-":
                        res = n1 - n2;
                        System.out.println("result: " + res);
                        break loop;
                    case "/":
                        res = n1 / n2;
                        System.out.println("result: " + res);
                        break loop;
                    case "*":
                        res = n1 * n2;
                        System.out.println("result: " + res);
                        break loop;
                    default:
                        System.out.println("Invalid operator. Try again.");
                        break loop;

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid number format. Try again.");
                in.nextLine();

            }
        }

    }
}
