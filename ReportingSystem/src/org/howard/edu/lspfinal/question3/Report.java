package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class that defines the template method for generating reports.
 * Uses the Template Method design pattern to define the skeleton of the report generation algorithm,
 * deferring some steps to subclasses.
 * 
 * @author Geehan
 * @version 1.0
 * 
 * @references
 * - Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Addison-Wesley.
 * - Freeman, E., Robson, E., Bates, B., & Sierra, K. (2004). Head First Design Patterns. O'Reilly Media.
 * - Bloch, J. (2018). Effective Java (3rd ed.). Addison-Wesley Professional.
 */
public abstract class Report {
    
    /**
     * Template method that defines the skeleton of the report generation algorithm.
     * The sequence is fixed, but subclasses can override the individual steps.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }
    
    /**
     * Hook method for loading data.
     * Subclasses must implement this to provide specific data loading behavior.
     */
    protected abstract void loadData();
    
    /**
     * Hook method for formatting data.
     * Subclasses must implement this to provide specific data formatting behavior.
     */
    protected abstract void formatData();
    
    /**
     * Hook method for printing the report.
     * Subclasses must implement this to provide specific report printing behavior.
     */
    protected abstract void printReport();
}