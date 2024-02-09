package taskManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskManagerTest {

	@Test
	void testAddPersonalTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new PersonalTask(0, "test_task");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotSame("Task added", testTaskManager.addTask(testTask));
		assertSame("Operation Invalid, Task already exists", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
	}
	
	@Test
	void testRemovePersonalTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new PersonalTask(0, "test_task");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
		assertSame("Success", testTaskManager.removeTask(0));
		assertSame("Failure, task doesnt exist", testTaskManager.removeTask(1));
	}
	
	@Test
	void testAddWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new WorkTask(0, "test_task");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotSame("Task added", testTaskManager.addTask(testTask));
		assertSame("Operation Invalid, Task already exists", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
	}
	
	@Test
	void testRemoveWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new WorkTask(0, "test_task");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
		assertSame("Success", testTaskManager.removeTask(0));
		assertSame("Failure, task doesnt exist", testTaskManager.removeTask(1));
	}
	
	@Test
	void testAddTeamWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new TeamWorkTask(0, "test_task", "");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotSame("Task added", testTaskManager.addTask(testTask));
		assertSame("Operation Invalid, Task already exists", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
	}
	
	@Test
	void testRemoveTeamWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new TeamWorkTask(0, "test_task", "");
		assertNotNull(testTask);
		assertSame("Task added", testTaskManager.addTask(testTask));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask, testTaskManager.getTask(0));
		assertSame("Success", testTaskManager.removeTask(0));
		assertSame("Failure, task doesnt exist", testTaskManager.removeTask(1));
	}
}
