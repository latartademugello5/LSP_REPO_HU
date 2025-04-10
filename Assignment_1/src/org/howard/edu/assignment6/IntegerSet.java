package org.howard.edu.assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements a set of integers with various set operations
 * @author Geehan Altayb
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor for creating an empty set
     */
    public IntegerSet() {
    }

    /**
     * Constructor for creating a set with initial values
     * @param set ArrayList of integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        // Make sure we don't add duplicates
        for (Integer item : set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Clears the internal representation of the set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set
     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines if two sets are equal
     * Two sets are equal if they contain all of the same values in ANY order
     * @param o the object to compare this set against
     * @return true if the sets are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (!(o instanceof IntegerSet)) {
            return false;
        }
        
        IntegerSet otherSet = (IntegerSet) o;
        
        if (this.length() != otherSet.length()) {
            return false;
        }
        
        // Check if all elements of this set are in the other set
        for (Integer item : set) {
            if (!otherSet.contains(item)) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Checks if the set contains a specific value
     * @param value the value to check for
     * @return true if the set contains the value, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Finds the largest item in the set
     * @return the largest element in the set
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        
        int largest = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) > largest) {
                largest = set.get(i);
            }
        }
        
        return largest;
    }

    /**
     * Finds the smallest item in the set
     * @return the smallest element in the set
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        
        int smallest = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) < smallest) {
                smallest = set.get(i);
            }
        }
        
        return smallest;
    }

    /**
     * Adds an item to the set if it's not already present
     * @param item the integer to add to the set
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it's present
     * @param item the integer to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union operation with another set.
     * Adds all elements from the other set to this set.
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int i = 0; i < intSetb.set.size(); i++) {
            int element = intSetb.set.get(i);
            if (!this.contains(element)) {
                this.add(element);
            }
        }
    }

    /**
     * Performs the intersection operation with another set.
     * Keeps only elements that are in both sets.
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        
        for (Integer element : this.set) {
            if (intSetb.contains(element)) {
                result.add(element);
            }
        }
        
        this.set = result;
    }

    /**
     * Performs the set difference operation (this set - intSetb).
     * Removes all elements in this set that are also in intSetb.
     * @param intSetb the set to subtract
     */
    public void diff(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        
        for (Integer element : this.set) {
            if (!intSetb.contains(element)) {
                result.add(element);
            }
        }
        
        this.set = result;
    }

    /**
     * Performs the complement operation.
     * Sets this set to contain all elements in intSetb that are not in this set.
     * @param intSetb the universal set to complement against
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        
        for (Integer element : intSetb.set) {
            if (!this.contains(element)) {
                result.add(element);
            }
        }
        
        this.set = result;
    }

    /**
     * Checks if the set is empty
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set
     * @return a string showing all elements in the set
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if (i < set.size() - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}