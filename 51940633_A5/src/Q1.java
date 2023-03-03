import java.text.DecimalFormat;

public class Q1 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 1; i < 6; i++) {
            System.out.println(df.format(f(i)));
        }
    }

    public static double f(int i) {
        if (i == 0) {
            return 0;
        }
        return f(i - 1) + (1.0 / (2 * i));
    }

}
