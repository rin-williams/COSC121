import java.io.FileInputStream;
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) throws Exception {
        viewHex("data.dat");
    }

    private static void viewHex(String filename) {
        try {
            FileInputStream in = new FileInputStream(
                    "/Users/rin/eclipse-workspace/COSC121/51940633_A4/src/" + filename);
            int count = 0;
            int countHex = 0;
            while (in.available() > 0) {
                String hex = Integer.toHexString(in.read()).toUpperCase();
                if (count < 8) {
                    if (countHex < 2) {
                        System.out.print(hex.length() == 1 ? "0" + hex + " " : hex + " ");
                    } else {
                        System.out.print("\n" + (hex.length() == 1 ? "0" + hex + " " : hex + " "));
                        countHex = 0;
                    }
                    count++;
                } else {
                    countHex++;
                    if (countHex < 2) {
                        System.out.print("| ");
                    }
                    count = 0;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Something went wrong! Please try again.");
        }
    }
}