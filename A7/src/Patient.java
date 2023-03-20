public class Patient implements Comparable<Patient> {
	// attributes
	private String name;
	private int order; // order of arrival
	private int emergency; // 1 is normal, 5 is life-and-death situation

	// constructor
	public Patient(int order, String name, int priority) {
		this.order = order;
		this.name = name;
		this.emergency = priority;
	}

	// compare them base on their emergency first, then we compare them base on
	// order if the emergency is equal to each other.
	public int compareTo(Patient other) {
		if (this.emergency > other.emergency) {
			return -1;
		} else if (this.emergency < other.emergency) {
			return 1;
		} else {
			if (this.order > other.order) {
				return 1;
			} else if (this.order < other.order) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	// getters and setters
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

	public int getEmergency() {
		return emergency;
	}

	public void setEmergency(int emergency) {
		this.emergency = emergency;
	}

	public String toString() {
		return name;
	}
}
