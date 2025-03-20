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
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");
        
        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        
        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);
        
        // Displaying results
        System.out.println("Winner: " + vm.getWinner());
    }
}
