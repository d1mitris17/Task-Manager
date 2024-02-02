package taskManagementSystem;

public class WorkTask extends Task {

	public WorkTask(int ID, String name, String description) {
		super(ID, name, description);
	}
	
	public WorkTask(int ID, String name) {
		super(ID, name);
	}
	
	public String toString() {
		return "Task Type: Work\n" + super.toString();
	}

}
