import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class printWriter {
    public static void main(String[] args) {
        int x = 1234567890;
        try (PrintWriter out = new PrintWriter(new FileOutputStream("t.txt", true))) {
            out.print(x);
        } catch (IOException e) {
        }
    }
}
