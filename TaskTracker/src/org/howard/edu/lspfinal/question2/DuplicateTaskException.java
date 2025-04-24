package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to add a task with a name that already exists.
 * This is a checked exception that must be explicitly caught or declared.
 * 
 * @author Geehan
 * @version 1.0
 * @references
 *   - Bloch, J. (2018). Effective Java (3rd ed.). Addison-Wesley Professional.
 *   - Oracle. (2023). Java Exception Handling. https://docs.oracle.com/javase/tutorial/essential/exceptions/
 */
public class DuplicateTaskException extends Exception {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a DuplicateTaskException with a detail message specifying the duplicate task name.
     * 
     * @param taskName the name of the task that already exists
     */
    public DuplicateTaskException(String taskName) {
        super("Task '" + taskName + "' already exists.");
    }
}
