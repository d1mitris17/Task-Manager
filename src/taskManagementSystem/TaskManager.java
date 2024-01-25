package taskManagementSystem;

import java.util.ArrayList;

public class TaskManager {
	private ArrayList<Task> tasks; // create class variable 

	public TaskManager() { // initialise arrayList on object creation
		this.tasks = new ArrayList<Task>();
	}

	public void addTask(Task newTask) { 
		for (Task task : this.tasks) { // loops tasks to see if task ID exists already
			if(task.getID() == newTask.getID()) {
				System.out.println("Operation Invalid, Task already exists");
				return; // use return statement to stop loop from continuing
			}
		}
		this.tasks.add(newTask); // adds task if return statement is not reached - task ID is unique 
		System.out.println("Task added");
	}

	public void removeTask(int removeID) {
		for (int i = 0; i < this.getSize(); i++) { // loops tasks to see if task ID exists to remove
			if(this.tasks.get(i).getID() == removeID) {
				this.tasks.remove(i); // removes task from list
				System.out.println("Success");
				return; // ends function when task ID is found and removed
			}
		}
		System.out.println("Failure, task doesnt exist"); // prints fail message if task ID is not found and return is not reached
	}

	public int getSize() { // makes it easier to get the task arrayList size
		return this.tasks.size();
	}

	public void printTasks() { // Outputs textual representation of a class
		if (this.getSize() > 0) {
			for (Task task : this.tasks) // loop through tasks and print them using task class function
				System.out.println(task.displayTask());

		}
		else
			System.out.println("No Tasks Added"); // outputs message if no tasks were found in arraylistå

	}

}
