package taskManagementSystem;

public class TeamWorkTask extends Task {
	String teamName;

	public TeamWorkTask(int ID, String name, String description, String teamName) {
		super(ID, name, description);
		this.teamName = teamName;
	}
	
	public TeamWorkTask(int ID, String name, String teamName) {
		super(ID, name);
		this.teamName = teamName;
	}
	
	public String getDetails() {
		return "Task Type: Teamwork\n" + super.getDetails() + "\nTeam Name: " + this.teamName;
	}

}
