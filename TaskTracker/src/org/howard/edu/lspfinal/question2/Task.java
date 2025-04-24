package org.howard.edu.lspfinal.question2;

/**
 * Represents a task in the task tracker system.
 * Each task has a unique name, priority level, and status.
 * 
 * @author Geehan
 * @version 1.0
 * @references
 *   - Bloch, J. (2018). Effective Java (3rd ed.). Addison-Wesley Professional.
 *   - Oracle. (2023). Java Object Class. https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
 */
public class Task {
    private String name;
    private int priority;
    private String status;
    
    /**
     * Valid task statuses
     */
    public static final String STATUS_TODO = "TODO";
    public static final String STATUS_IN_PROGRESS = "IN_PROGRESS";
    public static final String STATUS_DONE = "DONE";

    /**
     * Constructs a new Task with the specified name, priority, and status.
     * 
     * @param name the unique name of the task
     * @param priority the priority of the task (lower number = higher priority)
     * @param status the current status of the task (TODO, IN_PROGRESS, or DONE)
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Gets the name of this task.
     * 
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the priority of this task.
     * 
     * @return the task priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the current status of this task.
     * 
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of this task.
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of this task.
     * 
     * @return a string representation of this task
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}