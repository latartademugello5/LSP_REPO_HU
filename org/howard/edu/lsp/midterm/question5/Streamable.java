package org.howard.edu.lsp.midterm.question5;

/**
 * Streamable interface defines common behaviors for all streamable media content
 */
public interface Streamable {
    /**
     * Play the media content
     */
    void play();
    
    /**
     * Pause the media content
     */
    void pause();
    
    /**
     * Stop the media content
     */
    void stop();
}
