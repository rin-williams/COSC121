import java.io.*;
import java.util.*;

public class Q4 {
    public static void main(String[] args) throws IOException {
        String[] censoredWords = { "ABC", "XYZ" };

        File src = new File("src/source.txt");
        Scanner in = new Scanner(src);

        File des = new File("src/destination2.txt");
        FileWriter file = new FileWriter(des);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            file.write(replaceCensoredWords(s, censoredWords) + "\n");
        }

        in.close();
        file.close();
    }

    private static String replaceCensoredWords(String line, String[] censoredWords) throws FileNotFoundException {
        Scanner in = new Scanner(line);
        String toCheck;
        String toReturn = "";
        loop: while (in.hasNext()) {
            toCheck = in.next();
            for (int j = 0; j < censoredWords.length; j++) {
                if (censoredWords[j].equalsIgnoreCase(toCheck)) {
                    toReturn += "... ";
                    continue loop;
                }
            }
            toReturn += toCheck.toUpperCase() + " ";

        }
        return toReturn;
    }
}
