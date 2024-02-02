package taskManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskManagerTest {

	@Test
	void testAddTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new Task(0, "test_task");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotSame("Task added", testTaskManager.addTask(testTask));
		assertSame("Operation Invalid, Task already exists", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
	}
	
	@Test
	void testRemoveTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new Task(0, "test_task");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
		assertSame("Success", testTaskManager.removeTask(0));
		assertSame("Failure, task doesnt exist", testTaskManager.removeTask(1));
	}

}
