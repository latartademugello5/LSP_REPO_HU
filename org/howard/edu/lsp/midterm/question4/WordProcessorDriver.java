package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * WordProcessorDriver demonstrates the functionality of the WordProcessor class
 */
public class WordProcessorDriver {
    /**
     * Main method to test the WordProcessor class
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test case 1: Sentence with a mix of uppercase and lowercase letters
        WordProcessor wp1 = new WordProcessor("Java coding is Great But CHALLENGING");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1); 
        // Expected Output: [CHALLENGING]

        // Test case 2: Sentence with hyphenated words
        WordProcessor wp2 = new WordProcessor("State-of-the-art technology is cutting-edge");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2); 
        // Expected Output: [State-of-the-art, cutting-edge]

        // Test case 3: Sentence with numbers included
        WordProcessor wp3 = new WordProcessor("The latest AI model is GPT-4 and 2025 looks promising");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longestWords3); 
        // Expected Output: [promising]

        // Test case 4: Sentence with an extremely long word
        WordProcessor wp4 = new WordProcessor("Supercalifragilisticexpialidocious is a fun word!");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4); 
        // Expected Output: [Supercalifragilisticexpialidocious]

        // Test case 5: Sentence with single-character words and mixed-case letters
        WordProcessor wp5 = new WordProcessor("A b C D e f G H I");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5); 
        // Expected Output: [A, b, C, D, e, f, G, H, I]
    }
}
