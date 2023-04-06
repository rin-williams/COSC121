import java.util.ArrayList;

public class execTime {
    static ArrayList<Patient> list;
    static double bubTime = 0, slcTime = 0, insTime = 0;
    static int quantity = 0;

    public static void main(String[] args) {

        System.out.print("\nRun 1:\n");
        System.out.printf("%5s%10s%10s%10s", "N", "Bubble", "Selection", "Insertion");
        for (int i = 5000; i <= 50000; i += 5000) {
            listStats(i);
        }

        System.out.print("\nRun 2:\n");
        System.out.printf("%5s%10s%10s%10s", "N", "Bubble", "Selection", "Insertion");
        for (int i = 5000; i <= 50000; i += 5000) {
            listStats(i);
        }
    }

    public static void listStats(int n) {
        addPatients(n);
        sortAll();
        System.out.printf("\n%5d%10.3f%10.3f%10.3f", n, bubTime, slcTime, insTime);
    }

    public static void addPatients(int n) {
        quantity = n;
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(randomPatient());
        }
    }

    public static Patient randomPatient() {
        int order = (int) (Math.random() * (quantity + 1));
        boolean emergencyCase = (int) (Math.random() * 2) == 0 ? false : true;
        return new Patient(order, "null", emergencyCase);
    }

    public static void sortAll() {
        ArrayList<Patient> toSort = (ArrayList<Patient>) list.clone();

        long startTime = System.currentTimeMillis();
        Sorter.bubbleSort(toSort);
        long endTime = System.currentTimeMillis();
        bubTime = (endTime - startTime) / 1000.0;

        toSort = (ArrayList<Patient>) list.clone();

        startTime = System.currentTimeMillis();
        Sorter.selectionSort(toSort);
        endTime = System.currentTimeMillis();
        slcTime = (endTime - startTime) / 1000.0;

        toSort = (ArrayList<Patient>) list.clone();

        startTime = System.currentTimeMillis();
        Sorter.insertionSort(toSort);
        endTime = System.currentTimeMillis();
        insTime = (endTime - startTime) / 1000.0;

    }
}
