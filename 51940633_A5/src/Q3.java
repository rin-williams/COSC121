import java.util.Scanner;

public class Q3 {
    // setting static int so i can use it in the main method when dupeCount is
    // computed in findDuplicate();
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

        if (beginIndex == s.length() - 1) { // if the index given is the same as the length of the string,
            if (s.charAt(s.length() - 1) == c) { // then compare it to see if that string is equal to the character
                dupeCount++; // increment dupe count.
                return dupeCount; // return value immediately because there are only one character in the string
                                  // given.
            }
            return dupeCount; // else, return dupecount or 0.

        } else if (s.charAt(beginIndex) == c) { // if the string at index 0 is equal to the character given
            dupeCount++; // increment dupecount
        }
        return findDuplicateHelper(s, c, beginIndex + 1); // return the same method but indent index by 1.
    }
}
