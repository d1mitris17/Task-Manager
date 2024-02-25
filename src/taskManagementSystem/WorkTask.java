package taskManagementSystem;

public class WorkTask extends Task implements Remindable{

	public WorkTask(int ID, String name, String description) {
		super(ID, name, description);
	}
	
	public WorkTask(int ID, String name) {
		super(ID, name);
	}
	
	public String getDetails() {
		return "Task Type: Work\n" + super.getDetails();
	}
	
	public String remindUser() {
		return  ("Remember to complete " + this.getName() + " task!");
		
	}
}
