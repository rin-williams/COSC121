import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double res = 0;

        System.out.print("Enter a simple mathematical formula: ");

        loop: while (true) {
            try {
                String s1 = in.next();
                String op = in.next();
                String s2 = in.next();
                Double n1 = Double.parseDouble(s1);
                Double n2 = Double.parseDouble(s2);

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
            } catch (NumberFormatException e) {
                // NumberFormateException was thrown contains something other than just double
                // number, which ultimately throw this exception at us.
                System.out.println("Invalid number format. Try again.");
                in.nextLine();

            }
        }

    }
}
