import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        System.out.print(reverse(in.next()));
        in.close();
    }

    public static String reverse(String s) {
        return reverseHelper(s, s.length() - 1);
    }

    public static String reverseHelper(String s, int beginIndex) {
        if (s.isEmpty()) {
            return "No string given\n";
        } else if (beginIndex == 0) {
            return "" + s.charAt(0);
        } else {
            return s.charAt(beginIndex) + reverseHelper(s, beginIndex - 1);
        }
    }
}
