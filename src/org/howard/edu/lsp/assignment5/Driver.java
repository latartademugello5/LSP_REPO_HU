package org.howard.edu.lsp.assignment5;

/**
 * Driver class to test the IntegerSet implementation.
 */
public class Driver {
    /**
     * Main method to demonstrate and test IntegerSet functionality.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test Set 1
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());
        System.out.println("Length of Set1 is: " + set1.length());
        System.out.println("Is Set1 empty? " + set1.isEmpty());

        // Test Set 2
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("\nValue of Set2 is: " + set2.toString());

        // Test Union
        System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 before union: " + set1.toString());
        System.out.println("Value of Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        // Test Intersect
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(4);
        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        set4.add(5);

        System.out.println("\nIntersection test");
        System.out.println("Set3: " + set3.toString());
        System.out.println("Set4: " + set4.toString());
        set3.intersect(set4);
        System.out.println("Result of intersection: " + set3.toString());

        // Test Difference
        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        set5.add(3);
        IntegerSet set6 = new IntegerSet();
        set6.add(3);
        set6.add(4);

        System.out.println("\nDifference test");
        System.out.println("Set5: " + set5.toString());
        System.out.println("Set6: " + set6.toString());
        set5.diff(set6);
        System.out.println("Result of difference (Set5 - Set6): " + set5.toString());

        // Test Complement
        IntegerSet set7 = new IntegerSet();
        set7.add(1);
        set7.add(2);
        set7.add(3);
        IntegerSet set8 = new IntegerSet();
        set8.add(3);
        set8.add(4);

        System.out.println("\nComplement test");
        System.out.println("Set7: " + set7.toString());
        System.out.println("Set8: " + set8.toString());
        set7.complement(set8);
        System.out.println("Result of complement of Set7 against Set8: " + set7.toString());
    }
}
