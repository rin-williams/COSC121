
public class reverseString {
    // make me a method that reveses a string input
    public static String reverse(String input) {
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            output += input.charAt(i);
        }
        return output;
    }

    public static void main(String[] args) {
        // test the method
        System.out.println(reverse("Hello World!"));
    }

    // compile this to a lamnda expression
    public static boolean isPalindromeLamnda(String input) {
        return reverse(input).equals(input);
    }
}