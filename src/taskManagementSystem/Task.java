package taskManagementSystem;

public class Task {
	private int ID;
	private String name;
	private String description;

	public Task(int ID, String name, String description) {
		this.ID = ID;
		this.name = name;
		this.description = description;
	}

	public Task(int ID, String name) {
		this(ID, name, "");
	}

	public String displayTask() {
		return "ID: " + this.ID + "\nName: " + this.name + "\nDescription: " + this.description;
	}

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

}
