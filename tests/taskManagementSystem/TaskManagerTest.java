package taskManagementSystem;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskManagerTest {

	@Test
	void testAddPersonalTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new PersonalTask(0, "test_task");
		Task testTask2 = new PersonalTask(1, "test_task2");
		assertAll(() -> testTaskManager.addTask(testTask));
		assertAll(() -> testTaskManager.addTask(testTask2));
		assertSame(testTask, testTaskManager.getTask(0));
		assertNotSame(testTask, testTaskManager.getTask(1));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask2, testTaskManager.getTask(1));
		assertThrows(TaskDuplicationException.class, () -> testTaskManager.addTask(testTask2));
	}
	
	@Test
	void testRemovePersonalTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new PersonalTask(0, "test_task");
		assertAll(() -> testTaskManager.addTask(testTask));
		assertThrows(TaskNotFoundException.class, () -> testTaskManager.removeTask(0));
		assertAll(() -> testTaskManager.removeTask(1));
	}
	
	@Test
	void testAddWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new WorkTask(0, "test_task");
		Task testTask2 = new WorkTask(1, "test_task");
		assertAll(() -> testTaskManager.addTask(testTask));
		assertAll(() -> testTaskManager.addTask(testTask2));
		assertSame(testTask, testTaskManager.getTask(0));
		assertNotSame(testTask, testTaskManager.getTask(1));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask2, testTaskManager.getTask(1));
		assertThrows(TaskDuplicationException.class, () -> testTaskManager.addTask(testTask2));
	}
	
	@Test
	void testRemoveWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new WorkTask(0, "test_task");
		assertAll(() -> testTaskManager.addTask(testTask));
		assertThrows(TaskNotFoundException.class, () -> testTaskManager.removeTask(0));
		assertAll(() -> testTaskManager.removeTask(1));
	}
	
	@Test
	void testAddTeamWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new TeamWorkTask(0, "test_task", "");
		Task testTask2 = new TeamWorkTask(1, "test_task_2", "");
		assertAll(() -> testTaskManager.addTask(testTask));
		assertAll(() -> testTaskManager.addTask(testTask2));
		assertSame(testTask, testTaskManager.getTask(0));
		assertNotSame(testTask, testTaskManager.getTask(1));
		assertNotNull(testTaskManager.getTask(0));
		assertSame(testTask2, testTaskManager.getTask(1));
		assertThrows(TaskDuplicationException.class, () -> testTaskManager.addTask(testTask2));
	}
	
	@Test
	void testRemoveTeamWorkTask() {
		TaskManager testTaskManager = new TaskManager();
		assertNotNull(testTaskManager);
		Task testTask = new TeamWorkTask(0, "test_task", "");
		assertAll(() -> testTaskManager.addTask(testTask));
		assertThrows(TaskNotFoundException.class, () -> testTaskManager.removeTask(0));
		assertAll(() -> testTaskManager.removeTask(1));
	}
}
