package taskManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUserInterface {
	private Scanner sc; 
	
	public TextUserInterface() {
		sc = new Scanner(System.in);
	}


	public void printTasks(TaskManager tasks) { // Outputs textual representation of a class
		if (tasks.getSize() > 0) {
			for (int i = 0; i < tasks.getSize(); i++) // loop through tasks and print them using task class function
				System.out.println(tasks.getTask(i).displayTask());
		}
		else
			System.out.println("No Tasks Added"); // outputs message if no tasks were found in arrayList

	}

	public void welcomeMessage() {
		System.out.println("Welcome to Task Manager"); // Welcome Message and Instructions
		System.out.println("-----------------------");
		System.out.println("Instructions:");
		System.out.println("Type the character in square"
				+ "\nbrackets to complete the corresponding\nfunction\n");
	}

	public String getUserChoice() {
		System.out.println("What function would you like" // Gives the user the Available functions
				+ "\nto complete?");
		System.out.println("[S]how all current tasks");
		System.out.println("[A]dd a new task");
		System.out.println("[R]emove an existing task");
		System.out.println("[E]xit the program");
		return sc.nextLine();
	}
	
	public Task addTask() {
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
		
		return new Task(userInputID, userInputName, userInputDescription); // adds new task to arrayList
		
	}
	
	public int removeTask() {
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
		return userInputID;
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

}
