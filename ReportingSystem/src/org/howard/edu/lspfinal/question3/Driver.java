package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate the reporting system using the Template Method pattern.
 * Shows how clients can use the framework to create and generate different types of reports.
 * 
 * @author Geehan
 * @version 1.0
 * 
 * @references
 * - Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Addison-Wesley.
 * - Freeman, E., Robson, E., Bates, B., & Sierra, K. (2004). Head First Design Patterns. O'Reilly Media.
 * - Martin, R. C. (2008). Clean Code: A Handbook of Agile Software Craftsmanship. Prentice Hall.
 */
public class Driver {
    /**
     * Main method to demonstrate the Template Method pattern in the reporting system.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create and generate a Sales report
        Report salesReport = new SalesReport();
        salesReport.generateReport();
        
        System.out.println(); // Empty line for separation
        
        // Create and generate an Inventory report
        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}