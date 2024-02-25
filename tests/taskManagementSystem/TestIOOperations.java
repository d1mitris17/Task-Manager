package taskManagementSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestIOOperations {
	
	private static TaskManager testTasksOut;
	private static TaskManager testTasksIn;
	private static TaskFileWriter out;
	private static TaskFileReader in;
	private static Task testTask1;
	private static Task testTask2;
	private static Task testTask3;

	@BeforeAll
	static void initialise() {
		testTasksOut = new TaskManager();
		testTasksIn = new TaskManager();
		out = new TaskFileWriter();
		in = new TaskFileReader();
		testTask1 = new PersonalTask(0, "PersonalTask");
		testTask2 = new WorkTask(1, "WorkTask");
		testTask3 = new TeamWorkTask(2, "TeamworkTask", "TestTeam");
		
		try {
			testTasksOut.addTask(testTask1);
			testTasksOut.addTask(testTask2);
			testTasksOut.addTask(testTask3);
		} catch (TaskDuplicationException e) {
			fail("failed to add tasks");
		}
		
	}
	
	@Test
	void testOperations() {
		out.writeTasks(testTasksOut, "test_tasks.txt"); // save tasks to text file
		in.readTasks(testTasksIn, "test_tasks.txt"); // read tasks to separate file manager (empty)
		assertEquals(
				testTasksOut.toString(),
				testTasksIn.toString() // Compare the list with output and input tasks to make surer its the same
				);
	}

}
