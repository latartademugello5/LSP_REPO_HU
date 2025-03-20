package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * WordProcessor processes a sentence and returns all longest words
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor initializes the WordProcessor with a sentence
     * @param sentence The sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence
     * @return List of all words with the maximum length in the order they appear
     */
    public List<String> findLongestWords() {
        // Create a list to store the longest words
        List<String> longestWords = new ArrayList<>();
        
        // If the input is empty, return an empty list
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }
        
        // Split the sentence into words, handling varying amounts of whitespace
        String[] words = sentence.trim().split("\\s+");
        
        // Find the maximum word length
        int maxLength = 0;
        for (String word : words) {
            // Remove any remaining punctuation (although the problem says there won't be any)
            String cleanWord = word.replaceAll("[.,!?;:]", "");
            
            if (cleanWord.length() > maxLength) {
                maxLength = cleanWord.length();
            }
        }
        
        // Collect all words with the maximum length
        for (String word : words) {
            // Remove any remaining punctuation
            String cleanWord = word.replaceAll("[.,!?;:]", "");
            
            if (cleanWord.length() == maxLength) {
                longestWords.add(cleanWord);
            }
        }
        
        return longestWords;
    }
}

