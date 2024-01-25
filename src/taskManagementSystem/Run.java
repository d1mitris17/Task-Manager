package taskManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		boolean run = true;  // used to let the main program run iteratively
		String userInput, userInputName, userInputDescription; // used to hold values for user input
		int userInputID = 0; // used to hold values for user input
		Scanner sc = new Scanner(System.in); // used to get user input
		TaskManager tasks = new TaskManager(); // used to store all of the users tasks

		System.out.println("Welcome to Task Manager"); // Welcome Message and Instructions
		System.out.println("-----------------------");
		System.out.println("Instructions:");
		System.out.println("Type the character in square"
				+ "\nbrackets to complete the corresponding\nfunction\n");

		while(run) { // Iteratively runs main body
			
			System.out.println("What function would you like" // Gives the user the Available functions
					+ "\nto complete?");
			System.out.println("[S]how all current tasks");
			System.out.println("[A]dd a new task");
			System.out.println("[R]emove an existing task");
			System.out.println("[E]xit the program");

			userInput = sc.nextLine(); // Assigns userInput so that the next Iteration performs new function
			
			switch (userInput.toUpperCase()) { // Uses a switch to perform function the user entered  
			case "S": { // uses the class function printTasks to print all the tasks added
				tasks.printTasks();
				break;
			}
			case "A": { // Adds a new task
				while (true) { // Asks the user for an int and then iterates if an Integer error occurred
					try {
						System.out.println("Enter new task ID: ");
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
				tasks.addTask(new Task(userInputID, userInputName, userInputDescription)); // adds new task to arrayList
				break;
			}
			case "R": { // removes task id entered
				while (true) { // Asks the user for an int and then iterates if an Integer error occurred
					try {
						System.out.println("Enter task ID to remove: ");
						userInputID = sc.nextInt();
						sc.nextLine(); // gets rid of new line character that nextInt hasnt parsed
					} catch (InputMismatchException e) { // catches exception if user entered a non integer
						System.out.print("Error, not an int...");
						sc.nextLine();
						continue;
					}
					break;
				}
				tasks.removeTask(userInputID);
				break;
			}
			case "E": { // Terminates loop and ends program
				System.out.println("Program terminated");
				run = false; // sets run to false to stop iterating
				break;
			}
			default:
				System.out.println("No function :" + userInput + " exists"); // lets user know that they entered an unavailable character
			}

		} 


		sc.close(); // Closes scanner object
	}

}
