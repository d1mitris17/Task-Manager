package taskManagementSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TaskFileWriter {

	public TaskFileWriter() {
		
	}
	
	public void writeTasks(TaskManager tasks, String filename) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for (Task task : tasks) {
				bw.write(task.getDetails() + "\n");
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("App failed to Save Tasks");
		}
	}
	
}
