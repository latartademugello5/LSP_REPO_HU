package org.howard.edu.assignment6;

/**
 * Driver class to test the IntegerSet implementation
 * @author Geehan Altayb
 */
public class Driver {
    public static void main(String[] args) {
        // Test case 1: Basic operations
        System.out.println("Test case 1: Basic operations");
        IntegerSet set1 = new IntegerSet();
        
        System.out.println("Set1 initially: " + set1.toString());
        System.out.println("Is set1 empty? " + set1.isEmpty());
        
        System.out.println("\nAdding elements to Set1...");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1 after adding elements: " + set1.toString());
        System.out.println("Is set1 empty? " + set1.isEmpty());
        System.out.println("Length of Set1: " + set1.length());
        
        System.out.println("\nTrying to add duplicate element 2...");
        set1.add(2);
        System.out.println("Set1 after adding duplicate: " + set1.toString());
        
        System.out.println("\nRemoving element 2...");
        set1.remove(2);
        System.out.println("Set1 after removing 2: " + set1.toString());
        
        System.out.println("\nChecking if Set1 contains element 3: " + set1.contains(3));
        System.out.println("Checking if Set1 contains element 5: " + set1.contains(5));
        
        // Test case 2: Largest and smallest
        System.out.println("\n\nTest case 2: Largest and smallest");
        try {
            System.out.println("Smallest value in Set1: " + set1.smallest());
            System.out.println("Largest value in Set1: " + set1.largest());
            
            System.out.println("\nAdding more elements to Set1...");
            set1.add(0);
            set1.add(10);
            set1.add(-5);
            System.out.println("Set1 after adding elements: " + set1.toString());
            
            System.out.println("Updated smallest value in Set1: " + set1.smallest());
            System.out.println("Updated largest value in Set1: " + set1.largest());
            
            // Testing exception
            System.out.println("\nClearing Set1...");
            set1.clear();
            System.out.println("Set1 after clearing: " + set1.toString());
            
            try {
                System.out.println("Attempting to get largest value from empty set...");
                set1.largest();
            } catch (IntegerSetException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
            
            try {
                System.out.println("Attempting to get smallest value from empty set...");
                set1.smallest();
            } catch (IntegerSetException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
            
        } catch (IntegerSetException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Test case 3: Set operations
        System.out.println("\n\nTest case 3: Set operations");
        
        // Recreate set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Create set2
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        
        // Test union
        System.out.println("\nUnion of Set1 and Set2");
        IntegerSet unionSet = new IntegerSet();
        unionSet.add(1);
        unionSet.add(2);
        unionSet.add(3);
        System.out.println("Before union - unionSet: " + unionSet.toString());
        unionSet.union(set2);
        System.out.println("After union - unionSet: " + unionSet.toString());
        
        // Test intersection
        System.out.println("\nIntersection of Set1 and Set2");
        IntegerSet intersectSet = new IntegerSet();
        intersectSet.add(1);
        intersectSet.add(2);
        intersectSet.add(3);
        System.out.println("Before intersection - intersectSet: " + intersectSet.toString());
        intersectSet.intersect(set2);
        System.out.println("After intersection - intersectSet: " + intersectSet.toString());
        
        // Test difference
        System.out.println("\nDifference of Set1 and Set2");
        IntegerSet diffSet = new IntegerSet();
        diffSet.add(1);
        diffSet.add(2);
        diffSet.add(3);
        System.out.println("Before difference - diffSet: " + diffSet.toString());
        diffSet.diff(set2);
        System.out.println("After difference - diffSet: " + diffSet.toString());
        
        // Test complement
        System.out.println("\nComplement of Set1 with respect to Set2");
        IntegerSet complementSet = new IntegerSet();
        complementSet.add(1);
        complementSet.add(2);
        System.out.println("Before complement - complementSet: " + complementSet.toString());
        System.out.println("Universe set (Set2): " + set2.toString());
        complementSet.complement(set2);
        System.out.println("After complement - complementSet: " + complementSet.toString());
        
        // Test case 4: Equals method
        System.out.println("\n\nTest case 4: Equals method");
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(1);
        set3.add(2);
        
        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        set4.add(4);
        set4.add(5);
        
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set3: " + set3.toString());
        System.out.println("Set4: " + set4.toString());
        
        System.out.println("Is Set1 equal to Set3? " + set1.equals(set3));
        System.out.println("Is Set1 equal to Set4? " + set1.equals(set4));
        System.out.println("Is Set1 equal to Set2? " + set1.equals(set2));
    }
}