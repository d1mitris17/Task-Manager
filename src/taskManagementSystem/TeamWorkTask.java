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
	
	public String toString() {
		return "Task Type: Teamwork\n" + super.toString() + "\nTeam Name: " + this.teamName;
	}

}
