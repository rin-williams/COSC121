import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter five integers: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        in.close();
        System.out.print("Your list without duplicates: " + noDuplicates(list));
    }

    public static ArrayList<Integer> noDuplicates(ArrayList<Integer> list) {
        Iterator<Integer> it = list.iterator();
        ArrayList<Integer> toReturn = new ArrayList<>();
        int nextInt;

        toReturn.add(it.next());
        while (it.hasNext()) {
            if (!toReturn.contains(nextInt = it.next())) {
                toReturn.add(nextInt);
            }
        }
        return toReturn;
    }
}
