import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    static int key = 100;

    public static void main(String[] args) throws IOException {
        writeA();
        encrypt("a.dat", key);
        decrypt("a.dat.enc", 100);
        File file;
        file = new File("a.dat");
        file.delete();
        file = new File("a.dat.enc");
        file.delete();
    }

    private static void decrypt(String filename, int decryptKey) throws IOException {

        if (decryptKey != key) {
            throw new IllegalArgumentException("Invalid Key");
        } else {
            DataInputStream in = new DataInputStream(new FileInputStream(filename));
            System.out.println("The file encryped was:");
            while (in.available() > 0) {
                System.out.print(in.readByte() + " ");
                in.readByte();
            }
            in.close();
        }

    }

    private static void encrypt(String filename, int encryptKey) throws IOException {

        if (encryptKey < 0 || encryptKey > 100) {
            throw new IllegalArgumentException("Invalid Key");
        } else {
            DataInputStream in = new DataInputStream(new FileInputStream(filename));
            DataOutputStream out = new DataOutputStream(new FileOutputStream(filename + ".enc"));
            while (in.available() > 0) {
                out.writeByte(in.read());
                out.writeByte(encryptKey);
            }
            in.close();
            out.close();
        }
    }

    public static void writeA() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("a.dat"));
        out.writeInt(5);
        out.write(5);
        out.writeChar('X');
        out.writeUTF("X");
        out.close();
    }
}
