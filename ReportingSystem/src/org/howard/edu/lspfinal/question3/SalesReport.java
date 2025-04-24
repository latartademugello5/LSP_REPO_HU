package org.howard.edu.lspfinal.question3;

/**
 * Concrete implementation of the Report class for Sales department reports.
 * Implements the hook methods defined in the abstract Report class.
 * 
 * @author Geehan
 * @version 1.0
 * 
 * @references
 * - Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Addison-Wesley.
 * - Freeman, E., Robson, E., Bates, B., & Sierra, K. (2004). Head First Design Patterns. O'Reilly Media.
 */
public class SalesReport extends Report {
    
    /**
     * Implements the data loading step for sales data.
     */
    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
        // In a real implementation, this would connect to a database or file
        // and load sales-specific data
    }
    
    /**
     * Implements the data formatting step for sales data.
     */
    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
        // In a real implementation, this would transform the raw data
        // into a format suitable for a sales report
    }
    
    /**
     * Implements the report printing step for sales data.
     */
    @Override
    protected void printReport() {
        System.out.println("Printing sales report.");
        // In a real implementation, this would output the formatted report
        // to a file, display, or other output medium
    }
}