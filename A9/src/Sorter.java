import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {
    public static void bubbleSort(ArrayList<Patient> list) {
        boolean sorted = false;
        for (int k = 0; k < list.size(); k++) {
            sorted = true;
            // loop thru the list.
            for (int i = 0; i < list.size() - k - 1; i++) {
                // now take the current element and compare it to the next.
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    // if this is greater than the other, swap it.
                    // assume we sort it in ascending order.
                    Patient temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }

            }
        }
    }

    public static void bubbleSort(ArrayList<Patient> list, Comparator<Patient> comparator) {
        boolean sorted = false;
        for (int k = 0; k < list.size(); k++) {
            sorted = true;
            // loop thru the list.
            for (int i = 0; i < list.size() - k - 1; i++) {
                // now take the current element and compare it to the next.
                if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                    // if this is greater than the other, swap it.
                    // assume we sort it in ascending order.
                    Patient temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }

            }
        }
    }

    public static void selectionSort(ArrayList<Patient> list) {
        for (int i = 0; i < list.size(); i++) {
            // assume the min is the first index
            int iMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                // scan thru the entire list but exclude the first index.
                if (list.get(iMin).compareTo(list.get(j)) > 0) {
                    // if the current one is bigger than the one
                    // that is being scanned, then the scanned one
                    // is the new min.
                    iMin = j;
                }
            }
            // swap it.
            Patient temp = list.get(i);
            list.set(i, list.get(iMin));
            list.set(iMin, temp);
        }
    }

    public static void insertionSort(ArrayList<Patient> list) {
        for (int i = 1; i < list.size(); i++) {
            // remember the current item.
            Patient item = list.get(i);
            int pos;
            for (pos = i; pos > 0; pos--) {
                // if the previous one is larger than the current one.
                if (list.get(pos - 1).compareTo(item) > 0) {
                    list.set(pos, list.get(pos - 1));
                    // shift it to the right until it is not larger.
                } else {
                    break;
                }
            }
            // swap the current as well.
            list.set(pos, item);
        }
    }
}
