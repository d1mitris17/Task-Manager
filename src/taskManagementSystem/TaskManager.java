package taskManagementSystem;

import java.util.ArrayList;

public class TaskManager extends ArrayList<Task>{

	public TaskManager() { // initialise arrayList on object creation
	}

	public String addTask(Task newTask) { 
		for (Task task : this) { // loops tasks to see if task ID exists already
			if(task.getID() == newTask.getID()) {
				return "Operation Invalid, Task already exists"; // use return statement to stop loop from continuing
			}
		}
		this.add(newTask); // adds task if return statement is not reached - task ID is unique 
		return "Task added";
	}

	public String removeTask(int removeID) {
		for (int i = 0; i < this.getSize(); i++) { // loops tasks to see if task ID exists to remove
			if(this.get(i).getID() == removeID) {
				this.remove(i); // removes task from list
				return "Success"; // ends function when task ID is found and removed
			}
		}
		return "Failure, task doesnt exist"; // prints fail message if task ID is not found and return is not reached
	}

	public int getSize() { // makes it easier to get the task arrayList size
		return this.size();
	}

	public Task getTask(int i) {
		return this.get(i);
	}

	public String toString() { // Outputs textual representation of a class
		String s = "";
		if (this.getSize() > 0) {
			for (int i = 0; i < this.size(); i++) // loop through tasks and print them using task class function
				s += "\n" + this.get(i);
		}
		else
			s += "No Tasks Added"; // outputs message if no tasks were found in arrayList
		return s;

	}

}
