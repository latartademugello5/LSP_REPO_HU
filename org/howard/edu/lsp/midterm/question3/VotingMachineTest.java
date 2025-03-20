package org.howard.edu.lsp.midterm.question3;

/**
 * VotingMachineTest class to test the functionality of the VotingMachine class
 */
public class VotingMachineTest {
    /**
     * Main method to demonstrate the VotingMachine functionality
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();
        
        // Adding candidates
        vm.addCandidate("Cam");
        vm.addCandidate("Lyle");
        vm.addCandidate("Henry");
        
        // Casting votes
        vm.castVote("Cam");
        vm.castVote("Cam");
        vm.castVote("Lyle");
        vm.castVote("Henry");
        vm.castVote("Henry");
        vm.castVote("Henry");
        
        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Tye");
        System.out.println("Vote for Tye successful? " + success);
        
        // Displaying results
        System.out.println("Winner: " + vm.getWinner());
    }
}

