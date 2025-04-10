package org.howard.edu.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;
    
    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }
    
    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        // Test clearing an empty set
        set1.clear();
        assertEquals(0, set1.length(), "Clear on empty set should result in length 0");
        
        // Test clearing a non-empty set
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length(), "Set should have 3 elements before clear");
        set1.clear();
        assertEquals(0, set1.length(), "Set should have 0 elements after clear");
        assertTrue(set1.isEmpty(), "Set should be empty after clear");
    }
    
    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        // Test length of empty set
        assertEquals(0, set1.length(), "Empty set should have length 0");
        
        // Test length after adding elements
        set1.add(1);
        assertEquals(1, set1.length(), "Set with one element should have length 1");
        
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length(), "Set should have length 3 after adding 3 elements");
        
        // Test length after removing elements
        set1.remove(2);
        assertEquals(2, set1.length(), "Set should have length 2 after removing an element");
        
        // Test length with duplicate adds (should not increase length)
        set1.add(1); // Already exists
        assertEquals(2, set1.length(), "Adding duplicate element should not increase length");
    }
    
    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        // Test two empty sets
        assertTrue(set1.equals(set2), "Two empty sets should be equal");
        
        // Test sets with same elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(1);
        set2.add(2);
        set2.add(3);
        
        assertTrue(set1.equals(set2), "Sets with same elements should be equal");
        
        // Test sets with same elements in different order
        set2.clear();
        set2.add(3);
        set2.add(1);
        set2.add(2);
        
        assertTrue(set1.equals(set2), "Sets with same elements in different order should be equal");
        
        // Test sets with different elements
        set2.clear();
        set2.add(1);
        set2.add(2);
        set2.add(4);
        
        assertFalse(set1.equals(set2), "Sets with different elements should not be equal");
        
        // Test sets with different sizes
        set2.clear();
        set2.add(1);
        set2.add(2);
        
        assertFalse(set1.equals(set2), "Sets with different sizes should not be equal");
        
        // Test with null
        assertFalse(set1.equals(null), "Set should not be equal to null");
    }
    
    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        // Test contains on empty set
        assertFalse(set1.contains(1), "Empty set should not contain any element");
        
        // Test contains on a set with elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        assertTrue(set1.contains(1), "Set should contain element 1");
        assertTrue(set1.contains(2), "Set should contain element 2");
        assertTrue(set1.contains(3), "Set should contain element 3");
        assertFalse(set1.contains(4), "Set should not contain element 4");
        
        // Test after removing an element
        set1.remove(2);
        assertFalse(set1.contains(2), "Set should not contain element 2 after removal");
    }
    
    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        // Test largest for non-empty set
        set1.add(5);
        set1.add(10);
        set1.add(3);
        assertEquals(10, set1.largest(), "Largest element should be 10");
        
        // Add more elements and test again
        set1.add(7);
        set1.add(15);
        assertEquals(15, set1.largest(), "Largest element should be 15");
        
        // Remove largest and test again
        set1.remove(15);
        assertEquals(10, set1.largest(), "Largest element should be 10 after removing 15");
        
        // Test with negative numbers
        set1.clear();
        set1.add(-5);
        set1.add(-10);
        set1.add(-3);
        assertEquals(-3, set1.largest(), "Largest element should be -3");
    }
    
    @Test
    @DisplayName("Test exception case for largest")
    public void testLargestException() {
        // Test exception when set is empty
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
        
        String expectedMessage = "Set is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), 
                   "Exception message should contain '" + expectedMessage + "'");
    }
    
    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        // Test smallest for non-empty set
        set1.add(5);
        set1.add(10);
        set1.add(3);
        assertEquals(3, set1.smallest(), "Smallest element should be 3");
        
        // Add more elements and test again
        set1.add(7);
        set1.add(1);
        assertEquals(1, set1.smallest(), "Smallest element should be 1");
        
        // Remove smallest and test again
        set1.remove(1);
        assertEquals(3, set1.smallest(), "Smallest element should be 3 after removing 1");
        
        // Test with negative numbers
        set1.clear();
        set1.add(-5);
        set1.add(-10);
        set1.add(-3);
        assertEquals(-10, set1.smallest(), "Smallest element should be -10");
    }
    
    @Test
    @DisplayName("Test exception case for smallest")
    public void testSmallestException() {
        // Test exception when set is empty
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
        
        String expectedMessage = "Set is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), 
                   "Exception message should contain '" + expectedMessage + "'");
    }
    
    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        // Test adding to an empty set
        set1.add(1);
        assertEquals(1, set1.length(), "Length should be 1 after adding to empty set");
        assertTrue(set1.contains(1), "Set should contain the added element");
        
        // Test adding multiple elements
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length(), "Length should be 3 after adding 3 elements");
        assertTrue(set1.contains(2), "Set should contain the added element");
        assertTrue(set1.contains(3), "Set should contain the added element");
        
        // Test adding duplicate elements (should not change the set)
        set1.add(1);
        assertEquals(3, set1.length(), "Length should still be 3 after adding duplicate");
        
        // Test toString after adding elements
        String expected = "[1, 2, 3]"; // Assuming your toString looks like this
        assertEquals(expected, set1.toString(), "toString should reflect added elements");
    }
    
    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        // Test removing from an empty set (should do nothing)
        set1.remove(1);
        assertEquals(0, set1.length(), "Removing from empty set should not change length");
        
        // Test removing existing elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set1.remove(2);
        assertEquals(2, set1.length(), "Length should be 2 after removing one element");
        assertFalse(set1.contains(2), "Set should not contain the removed element");
        assertTrue(set1.contains(1), "Set should still contain other elements");
        assertTrue(set1.contains(3), "Set should still contain other elements");
        
        // Test removing non-existing element (should do nothing)
        set1.remove(4);
        assertEquals(2, set1.length(), "Removing non-existent element should not change length");
        
        // Test removing all elements
        set1.remove(1);
        set1.remove(3);
        assertEquals(0, set1.length(), "Length should be 0 after removing all elements");
        assertTrue(set1.isEmpty(), "Set should be empty after removing all elements");
    }
    
    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        // Test union with two empty sets
        set1.union(set2);
        assertEquals(0, set1.length(), "Union of two empty sets should be empty");
        
        // Test union with one empty set
        set1.add(1);
        set1.add(2);
        set1.union(set2);
        assertEquals(2, set1.length(), "Union with empty set should not change original set");
        
        // Test union with non-empty sets, no overlap
        set2.add(3);
        set2.add(4);
        set1.union(set2);
        assertEquals(4, set1.length(), "Union should include all elements from both sets");
        assertTrue(set1.contains(1), "Union should contain elements from first set");
        assertTrue(set1.contains(2), "Union should contain elements from first set");
        assertTrue(set1.contains(3), "Union should contain elements from second set");
        assertTrue(set1.contains(4), "Union should contain elements from second set");
        
        // Test union with overlap
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.union(set2);
        assertEquals(5, set1.length(), "Union with overlap should include distinct elements");
        assertTrue(set1.contains(1), "Union should contain all unique elements");
        assertTrue(set1.contains(2), "Union should contain all unique elements");
        assertTrue(set1.contains(3), "Union should contain all unique elements");
        assertTrue(set1.contains(4), "Union should contain all unique elements");
        assertTrue(set1.contains(5), "Union should contain all unique elements");
    }
    
    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        // Test intersection with two empty sets
        set1.intersect(set2);
        assertEquals(0, set1.length(), "Intersection of two empty sets should be empty");
        
        // Test intersection with one empty set
        set1.add(1);
        set1.add(2);
        set1.intersect(set2);
        assertEquals(0, set1.length(), "Intersection with empty set should be empty");
        
        // Test intersection with no common elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        
        set2.add(3);
        set2.add(4);
        
        set1.intersect(set2);
        assertEquals(0, set1.length(), "Intersection of disjoint sets should be empty");
        
        // Test intersection with common elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.intersect(set2);
        assertEquals(1, set1.length(), "Intersection should contain only common elements");
        assertTrue(set1.contains(3), "Intersection should contain the common element");
        assertFalse(set1.contains(1), "Intersection should not contain non-common elements");
        assertFalse(set1.contains(2), "Intersection should not contain non-common elements");
        assertFalse(set1.contains(4), "Intersection should not contain non-common elements");
        assertFalse(set1.contains(5), "Intersection should not contain non-common elements");
    }
    
    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        // Test difference with two empty sets
        set1.diff(set2);
        assertEquals(0, set1.length(), "Difference of two empty sets should be empty");
        
        // Test difference with one empty set
        set1.add(1);
        set1.add(2);
        set1.diff(set2);
        assertEquals(2, set1.length(), "Difference with empty set should not change original set");
        
        // Test difference with empty first set
        set1.clear();
        set2.add(1);
        set2.add(2);
        set1.diff(set2);
        assertEquals(0, set1.length(), "Difference from empty set should remain empty");
        
        // Test difference with no common elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        
        set1.diff(set2);
        assertEquals(2, set1.length(), "Difference with no common elements should not change set");
        assertTrue(set1.contains(1), "Set should retain all original elements");
        assertTrue(set1.contains(2), "Set should retain all original elements");
        
        // Test difference with common elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.diff(set2);
        assertEquals(2, set1.length(), "Difference should remove common elements");
        assertTrue(set1.contains(1), "Difference should keep elements unique to first set");
        assertTrue(set1.contains(2), "Difference should keep elements unique to first set");
        assertFalse(set1.contains(3), "Difference should remove common elements");
        assertFalse(set1.contains(4), "Difference should not contain elements from second set");
        assertFalse(set1.contains(5), "Difference should not contain elements from second set");
    }
    
    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        // Test complement with two empty sets
        set1.complement(set2);
        assertEquals(0, set1.length(), "Complement with empty universe should be empty");
        
        // Test complement with empty set
        set2.add(1);
        set2.add(2);
        set1.complement(set2);
        assertEquals(2, set1.length(), "Complement of empty set should be the universe");
        assertTrue(set1.contains(1), "Complement should contain all elements from universe");
        assertTrue(set1.contains(2), "Complement should contain all elements from universe");
        
        // Test complement with sets having no common elements
        set1.clear();
        set1.add(3);
        set1.add(4);
        
        set2.clear();
        set2.add(1);
        set2.add(2);
        
        set1.complement(set2);
        assertEquals(2, set1.length(), "Complement should contain elements only in universe");
        assertTrue(set1.contains(1), "Complement should contain elements from universe not in original");
        assertTrue(set1.contains(2), "Complement should contain elements from universe not in original");
        assertFalse(set1.contains(3), "Complement should not contain elements from original set");
        assertFalse(set1.contains(4), "Complement should not contain elements from original set");
        
        // Test complement with overlapping sets
        set1.clear();
        set1.add(1);
        set1.add(3);
        
        set2.clear();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        set1.complement(set2);
        assertEquals(2, set1.length(), "Complement should be elements in universe but not in original");
        assertTrue(set1.contains(2), "Complement should contain elements unique to universe");
        assertTrue(set1.contains(4), "Complement should contain elements unique to universe");
        assertFalse(set1.contains(1), "Complement should not contain common elements");
        assertFalse(set1.contains(3), "Complement should not contain common elements");
    }
    
    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        // Test isEmpty on empty set
        assertTrue(set1.isEmpty(), "New set should be empty");
        
        // Test isEmpty after adding elements
        set1.add(1);
        assertFalse(set1.isEmpty(), "Set with elements should not be empty");
        
        // Test isEmpty after removing all elements
        set1.remove(1);
        assertTrue(set1.isEmpty(), "Set with all elements removed should be empty");
        
        // Test isEmpty after clearing
        set1.add(1);
        set1.add(2);
        assertFalse(set1.isEmpty(), "Set with elements should not be empty");
        set1.clear();
        assertTrue(set1.isEmpty(), "Cleared set should be empty");
    }
    
    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        // Test toString on empty set
        String expected = "[]"; // Assuming your toString for empty set looks like this
        assertEquals(expected, set1.toString(), "toString of empty set should be " + expected);
        
        // Test toString with one element
        set1.add(1);
        expected = "[1]"; // Assuming your toString looks like this
        assertEquals(expected, set1.toString(), "toString with one element should be " + expected);
        
        // Test toString with multiple elements
        set1.add(2);
        set1.add(3);
        expected = "[1, 2, 3]"; // Assuming your toString looks like this
        assertEquals(expected, set1.toString(), "toString with multiple elements should be " + expected);
        
        // Test toString after removing elements
        set1.remove(2);
        expected = "[1, 3]"; // Assuming your toString looks like this
        assertEquals(expected, set1.toString(), "toString after removal should be " + expected);
        
        // Test toString after clearing
        set1.clear();
        expected = "[]"; // Assuming your toString for empty set looks like this
        assertEquals(expected, set1.toString(), "toString after clear should be " + expected);
    }
}