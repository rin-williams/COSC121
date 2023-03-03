import java.util.Scanner;

public class Q3 {
    static int dupeCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = in.nextLine();

        System.out.print("Enter a character: ");
        char c = in.next().charAt(0);

        System.out.println("" + c + " appears "
                + (findDuplicate(s, c) > 1 ? dupeCount + " times " : dupeCount + " time ") + "\"" + s + "\"");

        in.close();
    }

    public static int findDuplicate(String s, char c) {
        return findDuplicateHelper(s, c, 0);
    }

    public static int findDuplicateHelper(String s, char c, int beginIndex) {

        if (beginIndex == s.length() - 1) {
            if (s.charAt(s.length() - 1) == c) {
                dupeCount++;
                return dupeCount;
            }
            return dupeCount;

        } else if (s.charAt(beginIndex) == c) {
            dupeCount++;
        }
        return findDuplicateHelper(s, c, beginIndex + 1);
    }
}
