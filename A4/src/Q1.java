import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;

public class Q1 {

    public static void main(String[] args) throws IOException, EOFException, FileNotFoundException {
        int count = 0;
        File file = new File("src/count.dat");

        if (file.exists()) {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            count = in.readInt();
            in.close();

            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            out.writeInt(++count);
            out.close();

            System.out.println("This program has been run " + count + " times");
        } else {
            System.out.println("File does not exist, created a new file.");

            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

            file.createNewFile();

            out.writeInt(++count);
            out.close();
            System.out.println("This program has been run " + count + " time");
        }

    }

}
