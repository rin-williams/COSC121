import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Q3 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        long end;
        long timeTaken;

        System.out.println("Backing up...");
        int parts = BackupRestore.backup("src/syllabus.pdf", 0.25);
        end = System.currentTimeMillis();
        timeTaken = end - start;
        System.out.println("\nDone in " + timeTaken + " ms.");

        System.out.println("---");
        System.out.println("Restoring...");
        BackupRestore.restore("src/syllabus.pdf", parts);

        end = System.currentTimeMillis();
        timeTaken = end - start;
        System.out.println("\nDone in " + timeTaken + " ms.");

    }

}

class BackupRestore {

    public static int backup(String filename, double partSize) throws IOException {

        DecimalFormat df = new DecimalFormat("#.##");
        double numOfParts = 0;

        File file = new File(filename);

        if (file.exists()) {
            try {
                // finding size, how many parts etc...
                long sizeInBytes = file.length();
                int partSizeBytes = (int) (partSize * (1024 * 1024));

                double sizeInMegabytes = sizeInBytes / (double) (1024 * 1024);
                numOfParts = Math.ceil(sizeInMegabytes / partSize); // for excess bytes etc.

                System.out.println(sizeInBytes + " bytes. ~" + df.format(sizeInMegabytes)
                        + " megabytes. This file will be split into " + (int) numOfParts + " parts");

                // splitting files
                FileInputStream in = new FileInputStream(filename);
                for (int i = 0; i < numOfParts; i++) {

                    File fileOutput = new File(filename + "." + i);

                    FileOutputStream out = new FileOutputStream(fileOutput);

                    for (int j = 0; j < partSizeBytes; j++) {
                        int b;
                        if ((b = in.read()) != -1) { // in.read() will return -1 if it is at the end, to avoid errors,
                                                     // at the end of our part size, we make a safer way to write it.
                            out.write(b);
                        }
                    }

                    out.close();
                }
                in.close();
                System.out.println("File backed up.");
            } catch (Exception e) {
                System.out.println("\nSomething happened! Please try again!\n");
                e.printStackTrace();
            }
        } else {
            System.out.println("There are no file named '" + filename + "' in the src folder.");
            return 0;
        }
        return (int) numOfParts;
    }

    public static int restore(String filename, int numberOfPieces) throws IOException {
        File file = new File(filename);
        File filePiece;
        long sizeInBytes;
        FileOutputStream out = new FileOutputStream(file);

        for (int i = 0; i < numberOfPieces; i++) {
            filePiece = new File(filename + "." + i);
            sizeInBytes = filePiece.length();

            System.out.println("Size of file " + i + ": " + sizeInBytes + " bytes");

            FileInputStream in = new FileInputStream(filePiece);
            try {

                for (int j = 0; j < sizeInBytes; j++) {
                    int b;
                    if ((b = in.read()) != -1) {

                        out.write(b);
                    }
                }
            } catch (Exception e) {
                System.out.println("Something happened! Please try again!\n");
                e.printStackTrace();
            }

            in.close();
        }
        out.close();
        System.out.println("File restored, it has a size of " + file.length() + " bytes");
        return numberOfPieces;
    }

}