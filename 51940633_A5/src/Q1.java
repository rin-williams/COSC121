public class Q1 {
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            // formatting the f(i) so that it doesnt print all of the double decimals.
            System.out.printf("i = %d   f(i) = %.2f\n", i, f(i));
        }
    }

    public static double f(int i) {
        // base case if i becomes 0.
        if (i == 0) {
            return 0;
        }
        // recursive call, if i > 0, this will run,
        return f(i - 1) + (1.0 / (2 * i));
    }

}
