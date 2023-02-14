import java.io.*;
import java.util.*;

public class Q4 {
    public static void main(String[] args) throws Exception {
        String[] censoredWords = { "ABC", "XYZ" };

        File source = new File("src/source.txt");
        FileWriter file = new FileWriter("src/destination2.txt");

        Scanner in = new Scanner(source);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            s.toUpperCase();
            s.replaceCensoredWords(s, censoredWords);
            file.write(s);
        }

        in.close();
        file.close();

    }

    private static String replaceCensoredWords(String line, String[] censoredWords) throws FileNotFoundException {

        return "Done";
    }
}
