package taskManagementSystem;

public class Run {

	public static void main(String[] args) {
		boolean run = true;  // used to let the main program run iteratively
		String userInput; // used to hold values for user input
		TaskManager tasks = new TaskManager(); // used to store all of the users tasks
		TextUserInterface ui = new TextUserInterface();

		ui.welcomeMessage();

		while(run) { // Iteratively runs main body

			userInput = ui.getUserChoice();
			
			switch (userInput.toUpperCase()) { // Uses a switch to perform function the user entered  

			case "S": { // uses the class function printTasks to print all the tasks added
				ui.printTasks(tasks);
				break;
			}

			case "A": { // Adds a new task
				tasks.addTask(ui.addTask());
				break;
			}
			case "P": { // Adds a new task
				tasks.addTask(ui.addPersonalTask());
				break;
			}
			case "W": { // Adds a new task
				tasks.addTask(ui.addWorkTask());
				break;
			}
			case "T": { // Adds a new task
				tasks.addTask(ui.addTeamWorkTask());
				break;
			}

			case "R": { // removes task id entered
				tasks.removeTask(ui.removeTask());
				break;
			}

			case "E": { // Terminates loop and ends program
				ui.endProgram();
				run = false; // sets run to false to stop iterating
				break;
			}

			default:
				ui.userInputError(userInput);
				break;
			}

		} 

		ui.close(); // Closes scanner object
	}

}
