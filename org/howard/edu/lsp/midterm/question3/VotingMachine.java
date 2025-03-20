package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * VotingMachine class implements a simple electronic voting system
 * that allows adding candidates, casting votes, and determining the winner
 */
public class VotingMachine {
    // Map to store candidates and their vote counts
    private Map<String, Integer> candidateVotes;
    
    /**
     * Constructor initializes the voting machine with an empty list of candidates
     */
    public VotingMachine() {
        candidateVotes = new HashMap<>();
    }
    
    /**
     * Adds a new candidate to the voting machine
     * @param name The name of the candidate to add
     */
    public void addCandidate(String name) {
        // Initialize the candidate with 0 votes
        candidateVotes.put(name, 0);
    }
    
    /**
     * Casts a vote for a specified candidate
     * @param name The name of the candidate to vote for
     * @return true if the vote was successful, false if the candidate doesn't exist
     */
    public boolean castVote(String name) {
        // Check if the candidate exists
        if (!candidateVotes.containsKey(name)) {
            return false;
        }
        
        // Increment the vote count for the candidate
        int currentVotes = candidateVotes.get(name);
        candidateVotes.put(name, currentVotes + 1);
        return true;
    }
    
    /**
     * Determines the winner of the election
     * @return A string indicating the winner and their vote count
     */
    public String getWinner() {
        String winner = "";
        int highestVotes = 0;
        
        // Find the candidate with the highest number of votes
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (entry.getValue() > highestVotes) {
                highestVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        
        // Check for tie (not specifically required in the problem, but good practice)
        boolean isTie = false;
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (entry.getValue() == highestVotes && !entry.getKey().equals(winner)) {
                isTie = true;
                break;
            }
        }
        
        if (isTie) {
            return "Election resulted in a tie with " + highestVotes + " votes each!";
        } else {
            return winner + " WINS with " + highestVotes + " votes!!";
        }
    }
    
    /**
     * Gets the total number of votes for a specific candidate
     * @param name The name of the candidate
     * @return The number of votes for the candidate, or -1 if the candidate doesn't exist
     */
    public int getVotes(String name) {
        if (!candidateVotes.containsKey(name)) {
            return -1;
        }
        return candidateVotes.get(name);
    }
}
