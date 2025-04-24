package org.howard.edu.lspfinal.question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages tasks in the task tracker system.
 * Provides functionality to add, retrieve, update, and list tasks.
 * 
 * @author Geehan
 * @version 1.0
 * @references
 *   - Bloch, J. (2018). Effective Java (3rd ed.). Addison-Wesley Professional.
 *   - Oracle. (2023). Java Collections Framework. https://docs.oracle.com/javase/tutorial/collections/
 *   - Schildt, H. (2019). Java: The Complete Reference (11th ed.). McGraw-Hill Education.
 */
public class TaskManager {
    private Map<String, Task> tasks;
    
    /**
     * Constructs a new TaskManager with an empty task collection.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }
    
    /**
     * Adds a new task to the manager.
     * 
     * @param name the unique name of the task
     * @param priority the priority of the task (lower number = higher priority)
     * @param status the initial status of the task
     * @throws DuplicateTaskException if a task with the given name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException(name);
        }
        
        tasks.put(name, new Task(name, priority, status));
    }
    
    /**
     * Retrieves a task by its name.
     * 
     * @param name the name of the task to retrieve
     * @return the task with the specified name
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException(name);
        }
        return task;
    }
    
    /**
     * Updates the status of an existing task.
     * 
     * @param name the name of the task to update
     * @param newStatus the new status for the task
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }
    
    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        // Initialize lists for each status
        Map<String, List<Task>> tasksByStatus = new HashMap<>();
        tasksByStatus.put(Task.STATUS_TODO, new ArrayList<>());
        tasksByStatus.put(Task.STATUS_IN_PROGRESS, new ArrayList<>());
        tasksByStatus.put(Task.STATUS_DONE, new ArrayList<>());
        
        // Group tasks by status
        for (Task task : tasks.values()) {
            List<Task> statusList = tasksByStatus.get(task.getStatus());
            if (statusList != null) {
                statusList.add(task);
            }
        }
        
        // Print tasks grouped by status
        System.out.println("Tasks grouped by status:");
        
        for (Map.Entry<String, List<Task>> entry : tasksByStatus.entrySet()) {
            String status = entry.getKey();
            List<Task> statusTasks = entry.getValue();
            
            System.out.println(status + ":");
            for (Task task : statusTasks) {
                System.out.println("  " + task);
            }
        }
    }
}