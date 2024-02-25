package taskManagementSystem;

import java.util.ArrayList;

public class TaskManager extends ArrayList<Task>{

	public TaskManager() { // initialise arrayList on object creation
	}

	public void addTask(Task newTask) throws TaskDuplicationException { 
		for (Task task : this) { // loops tasks to see if task ID exists already
			if(task.getID() == newTask.getID()) {
				throw new TaskDuplicationException(); // throw exception if task already exists
			}
		}
		this.add(newTask); // adds task if return statement is not reached - task ID is unique 
	}

	public void removeTask(int removeID) throws TaskNotFoundException {
		for (int i = 0; i < this.getSize(); i++) { // loops tasks to see if task ID exists to remove
			if(this.get(i).getID() == removeID) {
				this.remove(i); // removes task from list
				return; // ends function when task ID is found and removed
			}
		}
		throw new TaskNotFoundException(); // throw exception if task ID is not found
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
