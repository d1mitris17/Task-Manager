package taskManagementSystem;

public class Run {

	public static void main(String[] args) {
		boolean run = true;  // used to let the main program run iteratively
		String userInput; // used to hold values for user input
		TaskManager tasks = new TaskManager(); // used to store all of the users tasks
		TextUserInterface ui = new TextUserInterface(); // used for all system outputs and inputs
		TaskFileReader taskReader = new TaskFileReader(); // used to load existing tasks
		TaskFileWriter taskWriter = new TaskFileWriter(); // used to save tasks made by user

		ui.welcomeMessage(); // welcome user and tells them how to interact

		taskReader.readTasks(tasks); // 

		ui.printTasks(tasks); // prints all tasks saved to text file 
		ui.printRemindables(tasks); // prints all saved tasks that need to be reminded

		while(run) { // Iteratively runs main body

			userInput = ui.getUserChoice(); // gives user their option and receives input

			switch (userInput.toUpperCase()) { // Uses a switch to perform function the user entered  

			case "S": { // uses the class function printTasks to print all the tasks added
				ui.printTasks(tasks);
				break;
			}

			case "P": { // Adds a new task
				ui.addPersonalTask(tasks);
				break;
			}
			case "W": { // Adds a new task
				ui.addWorkTask(tasks);
				break;
			}
			case "T": { // Adds a new task
				ui.addTeamWorkTask(tasks);
				break;
			}

			case "R": { // removes task id entered
				ui.removeTask(tasks);
				break;
			}

			case "E": { // Terminates loop and ends program
				taskWriter.writeTasks(tasks);
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
