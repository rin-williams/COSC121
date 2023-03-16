package A9.toStudents;

import java.util.ArrayList;

public class PatientTestQ12 {
	public static void main(String[] args) {
		ArrayList<Patient> list = new ArrayList<>(5);
		list.add(new Patient(1, "p1", false));
		list.add(new Patient(2, "p2", false));
		list.add(new Patient(3, "p3", true));
		list.add(new Patient(4, "p4", false));
		list.add(new Patient(5, "p5", true));
		
		//before sorting
		System.out.printf("%-15s%25s\n", "Before sorting", list);	//should be [p1, p2, p3, p4, p5]
		
		//try bubble sort methods 	for Q1
		//Sorter.bubbleSort(list);
		//Sorter.bubbleSort(list, new PatientComparator());

		//other sort methods		for Q2
		//Sorter.selectionSort(list);
		//Sorter.insertionSort(list);

		//after sorting
		System.out.printf("%-15s%25s\n", "After sorting", list);	//should be [p3, p5, p1, p2, p4]
	}
}
