package taskManagementSystem;

public class Task {
	private int ID; // declares class variables
	private String name;
	private String description;

	public Task(int ID, String name, String description) { // Constructor with ID, name and description parameters
		this.ID = ID;
		this.name = name;
		this.description = description;
	}

	public Task(int ID, String name) { // Constructor with only ID and name parameters
		this(ID, name, "");
	}

	public String displayTask() { // returns textual representation of class
		return "ID: " + this.ID + "\nName: " + this.name + "\nDescription: " + this.description;
	}

	// getters for class variables
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
