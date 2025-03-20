package org.howard.edu.lsp.midterm.question2;

/**
 * Book class represents a book in a library
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;
    
    /**
     * Constructor for creating a Book object
     * @param title The title of the book
     * @param author The author of the book
     * @param ISBN The ISBN number of the book (a unique identifier)
     * @param yearPublished The year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }
    
    /**
     * Gets the title of the book
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title of the book
     * @param title The title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the author of the book
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Sets the author of the book
     * @param author The author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * Gets the ISBN of the book
     * @return The ISBN of the book
     */
    public String getISBN() {
        return ISBN;
    }
    
    /**
     * Sets the ISBN of the book
     * @param ISBN The ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    /**
     * Gets the year the book was published
     * @return The year the book was published
     */
    public int getYearPublished() {
        return yearPublished;
    }
    
    /**
     * Sets the year the book was published
     * @param yearPublished The year published to set
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    
    /**
     * Overrides the equals method to compare books based on ISBN and author
     * @param obj The object to compare with
     * @return true if the books have the same ISBN and author, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
    }
    
    /**
     * Returns a string representation of the book
     * @return A string containing the book's title, author, ISBN, and year published
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
