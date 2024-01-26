package taskManagementSystem;

public class Run {

	public static void main(String[] args) {
		boolean run = true;  // used to let the main program run iteratively
		String userInput, userInputName, userInputDescription; // used to hold values for user input
		int userInputID = 0; // used to hold values for user input
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
				userInputID = ui.getID();
				userInputName = ui.getTaskName();
				userInputDescription = ui.getDescription();
				tasks.addTask(new Task(userInputID, userInputName, userInputDescription)); // adds new task to arrayList
				break;
			}

			case "R": { // removes task id entered
				userInputID = ui.getID();
				tasks.removeTask(userInputID);
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
