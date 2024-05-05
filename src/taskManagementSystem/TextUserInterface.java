package taskManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUserInterface {
	private Scanner sc;

	public TextUserInterface() {
		sc = new Scanner(System.in);
	}

	public void printTasks(TaskManager tasks) { // Outputs textual representation of a class
		System.out.println("\nHere are the Current Tasks");
		System.out.println(tasks);
	}

	public void welcomeMessage() {
		System.out.println("Welcome to Task Manager"); // Welcome Message and Instructions
		System.out.println("-----------------------");
		System.out.println("Instructions:");
		System.out.println("Type the character in square"
				+ "\nbrackets to complete the corresponding\nfunction and press enter");
	}


	public String getUserChoice() {
		System.out.println("\nWhat function would you like" // Gives the user the Available functions
				+ "\nto complete?");
		System.out.println("[S]how all current tasks");
		System.out.println("Add a new [P]ersonal task");
		System.out.println("Add a new [W]ork task");
		System.out.println("Add a new [T]eamwork task");
		System.out.println("[R]emove an existing task");
		System.out.println("[E]xit the program");
		return sc.nextLine();
	}

	public void addPersonalTask(TaskManager tasks) {
		int userInputID;
		String userInputName, userInputDescription;

		while (true) { // Asks the user for an int and then iterates if an Integer error occurred
			try {
				System.out.println("Enter task ID: ");
				userInputID = sc.nextInt();
				sc.nextLine(); // gets rid of new line character that nextInt hasnt parsed
			} catch (InputMismatchException e) { // catches exception if user entered a non integer
				System.out.print("Error, a non integer was entered...");
				sc.nextLine();
				continue;
			}
			break;
		}

		do { // keeps on asking user to name task until a non-empty string is entered
			System.out.println("Enter new task name: "); 
			userInputName = sc.nextLine();
		} while (userInputName.equals("")); 

		System.out.println("Enter new task description(Optional): "); // Only asks user once as description is optional
		userInputDescription = sc.nextLine();

		try {
			tasks.addTask(new PersonalTask(userInputID, userInputName, userInputDescription));
		} catch (TaskDuplicationException e) {
			System.out.println("Failed to add task, a task with the same ID exists");;
		}

	}

	public void addWorkTask(TaskManager tasks) {
		int userInputID;
		String userInputName, userInputDescription;

		while (true) { // Asks the user for an int and then iterates if an Integer error occurred
			try {
				System.out.println("Enter task ID: ");
				userInputID = sc.nextInt();
				sc.nextLine(); // gets rid of new line character that nextInt hasnt parsed
			} catch (InputMismatchException e) { // catches exception if user entered a non integer
				System.out.print("Error, a non integer was entered...");
				sc.nextLine();
				continue;
			}
			break;
		}

		do { // keeps on asking user to name task until a non-empty string is entered
			System.out.println("Enter new task name: "); 
			userInputName = sc.nextLine();
		} while (userInputName.equals("")); 

		System.out.println("Enter new task description(Optional): "); // Only asks user once as description is optional
		userInputDescription = sc.nextLine();

		try {
			tasks.addTask(new WorkTask(userInputID, userInputName, userInputDescription));
		} catch (TaskDuplicationException e) {
			System.out.println("Failed to add task, a task with the same ID exists");;
		}

	}

	public void addTeamWorkTask(TaskManager tasks) {
		int userInputID;
		String userInputName, userInputDescription, userInputTeamname;

		while (true) { // Asks the user for an int and then iterates if an Integer error occurred
			try {
				System.out.println("Enter task ID: ");
				userInputID = sc.nextInt();
				sc.nextLine(); // gets rid of new line character that nextInt hasnt parsed
			} catch (InputMismatchException e) { // catches exception if user entered a non integer
				System.out.print("Error, a non integer was entered...");
				sc.nextLine();
				continue;
			}
			break;
		}

		do { // keeps on asking user to name task until a non-empty string is entered
			System.out.println("Enter new task name: "); 
			userInputName = sc.nextLine();
		} while (userInputName.equals(""));

		do { // keeps on asking user to name task until a non-empty string is entered
			System.out.println("Enter new task's Team name: "); 
			userInputTeamname = sc.nextLine();
		} while (userInputTeamname.equals("")); 

		System.out.println("Enter new task description(Optional): "); // Only asks user once as description is optional
		userInputDescription = sc.nextLine();

		try {
			tasks.addTask(new TeamWorkTask(userInputID, userInputName, userInputDescription, userInputTeamname));
		} catch (TaskDuplicationException e) {
			System.out.println("Failed to add task, a task with the same ID exists");;

		}

	}

	public void removeTask(TaskManager tasks) {
		int userInputID;
		while (true) { // Asks the user for an int and then iterates if an Integer error occurred
			try {
				System.out.println("Enter task ID: ");
				userInputID = sc.nextInt();
				sc.nextLine(); // gets rid of new line character that nextInt hasnt parsed
			} catch (InputMismatchException e) { // catches exception if user entered a non integer
				System.out.print("Error, a non integer was entered...");
				sc.nextLine();
				continue;
			}
			break;
		}
		try {
			tasks.removeTask(userInputID);
		} catch (TaskNotFoundException e) {
			System.out.println("Failed to remove task, a task with such ID doesn't exists");;
		}
	}

	public void endProgram() {
		System.out.println("Program terminated");
	}

	public void userInputError(String userInput) {
		System.out.println("No function :" + userInput + " exists"); // lets user know that they entered an unavailable character
	}

	public void close() {
		sc.close();
	}

	public void printRemindables(TaskManager tasks) {
		System.out.println("\n");
		for (Task task : tasks) {
			if (task instanceof Remindable) {
				System.out.println(((Remindable) task).remindUser());
			}
		}
	}

}
