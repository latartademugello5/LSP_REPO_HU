package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to access or modify a task that doesn't exist.
 * This is a checked exception that must be explicitly caught or declared.
 * 
 * @author Your Name
 * @version 1.0
 * @references
 *   - Bloch, J. (2018). Effective Java (3rd ed.). Addison-Wesley Professional.
 *   - Oracle. (2023). Java Exception Handling. https://docs.oracle.com/javase/tutorial/essential/exceptions/
 */
public class TaskNotFoundException extends Exception {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a TaskNotFoundException with a detail message specifying the missing task name.
     * 
     * @param taskName the name of the task that was not found
     */
    public TaskNotFoundException(String taskName) {
        super("Task '" + taskName + "' not found.");
    }
}
    