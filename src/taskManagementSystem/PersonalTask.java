package taskManagementSystem;

public class PersonalTask extends Task {

	public PersonalTask(int ID, String name) {
		super(ID, name);
	}
	
	public PersonalTask(int ID, String name, String description) {
		super(ID, name, description);
	}
	
	public String toString() {
		return "Task Type: Personal\n" + super.toString();
	}

}
