import java.io.File;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        File file = new File("/Users/");
        listAllFiles(file);
    }

    public static void listAllFiles(File dir, String spaces) {
        if (dir.isFile()) {
            System.out.println(spaces + dir.getName());
        } else {
            if (dir.isDirectory()) {
                System.out.println(spaces + "[" + dir.getName() + "]");
                for (int i = 0; i < dir.listFiles().length; i++) {
                    listAllFiles(dir.listFiles()[i], spaces + "  ");
                }

            }
        }

    }

    public static void listAllFiles(File dir) {
        if (!dir.exists()) {
            System.out.print("\nNo such file/dir. please type in a valid file/dir.\n> ");
            Scanner in = new Scanner(System.in);
            listAllFiles(new File(in.next()));
            in.close();
        } else {
            listAllFiles(dir, "");
        }
    }
}
