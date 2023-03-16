package A9.toStudents;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient>{
	public int compare(Patient p1, Patient p2) {	
		if(p1.isEmergencyCase() && !p2.isEmergencyCase())
			return -1;							//place p1 first
		else if(!p1.isEmergencyCase() && p2.isEmergencyCase())
			return 1; 							//place p2 first
		else			//if both are emergency or both are not emergency
			return p1.getOrder()-p2.getOrder(); //place smaller order first	
	}
}	



