package A9.toStudents;

public class Patient implements Comparable<Patient>{
	//attributes
	private int order;
	private String name;
	private boolean emergencyCase;

	//constructor
	public Patient(int order, String name, boolean emergencyCase) {
		this.order = order;
		this.name = name;
		this.emergencyCase = emergencyCase;
	}

	//compareTo
	public int compareTo(Patient other) {
		if(this.isEmergencyCase() && !other.isEmergencyCase())
			return -1;							//place this first
		else if(!this.isEmergencyCase() && other.isEmergencyCase())
			return 1; 							//place other first
		else			//if both are emergency or both are not emergency
			return this.getOrder()-other.getOrder(); //place smaller order first		
	}
	
	//getters and setters
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEmergencyCase() {
		return emergencyCase;
	}
	public void setEmergencyCase(boolean emergencyCase) {
		this.emergencyCase = emergencyCase;
	}

	public String toString() {
		return (isEmergencyCase()?"*":"") + name;
	}
}
