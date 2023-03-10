import java.io.File;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        File file = new File("/Users/rin/eclipse-workspace/DATA101");
        listAllFiles(file);
    }

    public static void listAllFiles(File dir, String spaces) {
        // when u first run this, it will check if the directory is a file
        // if it is, print it with the spaces which will be just "" and the name of the
        // file. if it isn't, print it with [] since it is a folder and
        // keep printing it if it still have files. then call recursive to check if
        // those files have other files in them whilst adding indentation.

        if (dir.isFile()) {
            System.out.println(spaces + dir.getName());
        } else {
            System.out.println(spaces + "[" + dir.getName() + "]");
            for (int i = 0; i < dir.listFiles().length; i++) {
                listAllFiles(dir.listFiles()[i], spaces + "  ");
            }

        }

    }

    public static void listAllFiles(File dir) {
        // you can either type out the directory ex: /Users/(name)/
        // or you can just stop the program and type it in the file var above.

        // this is test to see if the director actually exsists.
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
