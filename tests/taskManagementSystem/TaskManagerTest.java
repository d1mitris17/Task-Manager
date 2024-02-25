package taskManagementSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskManagerTest {
	
	@Test
	void testAddPersonalTask() {
		TaskManager testTaskManager = new TaskManager(); // Create variables for test use
		Task testTask = new PersonalTask(0, "test_task");
		Task testTask2 = new PersonalTask(0, "test_task2");
		
		try {
			testTaskManager.addTask(testTask); // checks a task is added without exception thrown
		} catch (TaskDuplicationException e) {
			fail("Task failed to be added");
		}
		
		assertSame(testTask, testTaskManager.getTask(0)); // checks correct task is returned
		assertNotSame(testTask2, testTaskManager.getTask(0));
		
		assertNotNull(testTaskManager.getTask(0)); // checks the task returned is not null
		
		assertThrows(TaskDuplicationException.class, () -> testTaskManager.addTask(testTask)); // checks that an exception is thrown if a task with the same ID is added
	}
	
	@Test
	void testRemovePersonalTask() {
		TaskManager testTaskManager = new TaskManager();
		Task testTask = new PersonalTask(0, "test_task");
		
		try {
			testTaskManager.addTask(testTask);
		} catch (TaskDuplicationException e) {
			fail("Task failed to be added");
		}
		
		assertThrows(TaskNotFoundException.class, () -> testTaskManager.removeTask(1)); // tests exception is thrown if invalid ID is thrown
		
		try {
			testTaskManager.removeTask(0); // checks no exception is thrown if a valid ID is passed
		} catch (TaskNotFoundException e) {
			System.out.println("Task was not found");
		} 
		
	}
	
	@Test
	void testAddWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		Task testTask = new WorkTask(0, "test_task");
		Task testTask2 = new WorkTask(1, "test_task");
		
		try {
			testTaskManager.addTask(testTask); // checks a task is added without exception thrown
		} catch (TaskDuplicationException e) {
			fail("Task failed to be added");
		}
		
		assertSame(testTask, testTaskManager.getTask(0)); // checks correct task is returned
		assertNotSame(testTask2, testTaskManager.getTask(0));
		
		assertNotNull(testTaskManager.getTask(0)); // checks the task returned is not null
		
		assertThrows(TaskDuplicationException.class, () -> testTaskManager.addTask(testTask)); // checks that an exception is thrown if a task with the same ID is added
	}
	
	@Test
	void testRemoveWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		Task testTask = new WorkTask(0, "test_task");
		
		try {
			testTaskManager.addTask(testTask);
		} catch (TaskDuplicationException e) {
			fail("Task failed to be added");
		}
		
		assertThrows(TaskNotFoundException.class, () -> testTaskManager.removeTask(1)); // tests exception is thrown if invalid ID is thrown
		
		try {
			testTaskManager.removeTask(0); // checks no exception is thrown if a valid ID is passed
		} catch (TaskNotFoundException e) {
			System.out.println("Task was not found");
		} 
	}
	
	@Test
	void testAddTeamWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		Task testTask = new TeamWorkTask(0, "test_task", "");
		Task testTask2 = new TeamWorkTask(1, "test_task_2", "");
		
		try {
			testTaskManager.addTask(testTask); // checks a task is added without exception thrown
		} catch (TaskDuplicationException e) {
			fail("Task failed to be added");
		}
		
		assertSame(testTask, testTaskManager.getTask(0)); // checks correct task is returned
		assertNotSame(testTask2, testTaskManager.getTask(0));
		
		assertNotNull(testTaskManager.getTask(0)); // checks the task returned is not null
		
		assertThrows(TaskDuplicationException.class, () -> testTaskManager.addTask(testTask)); // checks that an exception is thrown if a task with the same ID is added
	}
	
	@Test
	void testRemoveTeamWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		Task testTask = new TeamWorkTask(0, "test_task", "");
		
		try {
			testTaskManager.addTask(testTask);
		} catch (TaskDuplicationException e) {
			fail("Task failed to be added");
		}
		
		assertThrows(TaskNotFoundException.class, () -> testTaskManager.removeTask(1)); // tests exception is thrown if invalid ID is thrown
		
		try {
			testTaskManager.removeTask(0); // checks no exception is thrown if a valid ID is passed
		} catch (TaskNotFoundException e) {
			System.out.println("Task was not found");
		} 
	}
}
