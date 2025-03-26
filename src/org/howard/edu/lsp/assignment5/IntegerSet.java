package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet is a custom implementation of a set of integers with various set operations.
 * The set ensures no duplicate elements and provides methods for common set operations.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList
    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor creates an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set with a given ArrayList of integers.
     * 
     * @param set ArrayList of integers to initialize the set
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal by comparing their contents.
     * 
     * @param o the object to compare with this set
     * @return true if the sets contain the same elements in any order, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // Check if the object is an IntegerSet
        if (!(o instanceof IntegerSet)) {
            return false;
        }

        IntegerSet other = (IntegerSet) o;
        
        // Check if lengths are the same
        if (this.length() != other.length()) {
            return false;
        }

        // Check if all elements in this set are in the other set
        for (int item : this.set) {
            if (!other.contains(item)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the set contains a specific value.
     * 
     * @param value the integer to check for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * 
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }

        int max = set.get(0);
        for (int num : set) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Returns the smallest item in the set.
     * 
     * @return the smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }

        int min = set.get(0);
        for (int num : set) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Adds an item to the set if it's not already present.
     * 
     * @param item the integer to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * 
     * @param item the integer to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs a set union with another IntegerSet.
     * Adds all elements from the other set that are not already in this set.
     * 
     * @param intSetb the IntegerSet to perform union with
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!this.contains(item)) {
                this.add(item);
            }
        }
    }

    /**
     * Performs set intersection, keeping only elements present in both sets.
     * 
     * @param intSetb the IntegerSet to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs set difference, removing elements from this set that are in the other set.
     * 
     * @param intSetb the IntegerSet to subtract from this set
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs set complement, keeping only elements not in the other set.
     * 
     * @param intSetb the IntegerSet to use for complement
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>();
        for (int item : this.set) {
            if (!intSetb.contains(item)) {
                complementSet.add(item);
            }
        }
        this.set = complementSet;
    }

    /**
     * Checks if the set is empty.
     * 
     * @return true if the set contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return a string in the format [element1, element2, ...]
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
