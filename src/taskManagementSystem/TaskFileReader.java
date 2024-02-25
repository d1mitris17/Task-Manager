package taskManagementSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TaskFileReader {
	
	public TaskFileReader() {
		
	}

	public void readTasks(TaskManager tasks) {
		try { // read existing file and add saved tasks to task list
			BufferedReader br = new BufferedReader(new FileReader("tasks.txt")); // create new buffered reader

			String line = br.readLine(); // reads the first line of the file
			while(line != null) {
				switch (line.replace("Task Type: ", "")) { // replaces decoration text in line and uses switch to created the correct task
				case "Teamwork": {
					tasks.add(new TeamWorkTask(Integer.parseInt(br.readLine().replace("ID: ", "")),
							br.readLine().replace("Name: ", ""), br.readLine().replace("Description: ", ""),
							br.readLine().replace("Team Name: ", ""))); // reads line and replaces decoration text
					break;
				}
				case "Work": {
					tasks.add(new WorkTask(Integer.parseInt(br.readLine().replace("ID: ", "")),
							br.readLine().replace("Name: ", ""), br.readLine().replace("Descriptione: ", "")));
					break;
				}
				case "Personal": {
					tasks.add(new PersonalTask(Integer.parseInt(br.readLine().replace("ID: ", "")),
							br.readLine().replace("Name: ", ""), br.readLine().replace("Description: ", "")));
					break;
				}
				}
				line = br.readLine(); // increment to next line
			}
			br.close();	// closes buffered reader to save changes made to file
		} catch (FileNotFoundException e) {
			System.out.println("tasks.txt file does not exist, no saved files have been added");
		} catch (IOException e) {
			System.out.println("IO error occured, no saved files have been added");
		}
	}
	
}
