import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        printShuffled("story.txt");
    }

    public static void printShuffled(String filename) throws FileNotFoundException, IOException {
        File file = new File("/Users/rin/eclipse-workspace/COSC121/51940633_A6/src/" + filename);
        Scanner in = new Scanner(file);
        ArrayList<String> arr = new ArrayList<>();

        in.useDelimiter("[.:!?]");

        while (in.hasNext()) {
            arr.add(in.next());
        }
        in.close();

        FileWriter out = new FileWriter("/Users/rin/eclipse-workspace/COSC121/51940633_A6/src/teststory.txt");
        // only use this after clean up
        // FileWriter out = new FileWriter(file);

        System.out.println("Before shuffling\n" + arr);
        Collections.shuffle(arr);
        System.out.print("Ater shuffling\n");
        for (String s : arr) {
            System.out.print(s + ".");
            out.write(s + ".");
        }
        out.close();

    }
}
